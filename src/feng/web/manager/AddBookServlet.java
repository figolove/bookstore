package feng.web.manager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import feng.domain.Book;
import feng.service.BusinessServices;
import feng.util.Utils;

public class AddBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String updir = this.getServletContext().getRealPath("/images") + "\\";
		Properties prop  = doUpfile(request,updir);
		
		Book book = new Book();
		book.setAuthor(prop.getProperty("author"));
		book.setCategory_id(prop.getProperty("category_id"));
		book.setDescription(prop.getProperty("description"));
		book.setId(Utils.makeId());
		book.setImage(prop.getProperty("image"));
		book.setName(prop.getProperty("name"));
		book.setPrice(Double.parseDouble(prop.getProperty("price")));
		
		
		BusinessServices service = new BusinessServices();
		service.addBook(book);
		
		response.getWriter().write("��ӳɹ�����");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	public Properties doUpfile(HttpServletRequest request,String updir){
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List list = null;
		Properties prop = new Properties();
		try {
			list = upload.parseRequest(request);
			Iterator it = list.iterator();
			while(it.hasNext()){
				FileItem item = (FileItem) it.next();
				if(item.isFormField()){
					String name = item.getFieldName();
					String value = item.getString();
					prop.put(name, new String(value.getBytes("iso8859-1"),"UTF-8"));
				}else{
					String filename = item.getName();
					int pos = filename.lastIndexOf("\\");
					if(pos!=-1){
						filename = filename.substring(pos+1);
					}
					filename = Utils.makeId() + filename;
					String fullfilename = updir + filename;
					FileOutputStream out = new FileOutputStream(fullfilename);
					
					InputStream in = item.getInputStream();
					byte buffer[] = new byte[1024];
					int len = 0;
					while((len=in.read(buffer))>0){
						out.write(buffer,0,len);
					}
					in.close();
					out.close();
					item.delete();
					prop.put("image", filename);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return prop;
	}
}
