package feng.web.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import feng.domain.Page;
import feng.service.BusinessServices;

public class ListBookByPage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String category_id = request.getParameter("category_id");
		String pageNum = request.getParameter("pageNum");
		
		BusinessServices service = new BusinessServices();
		Page page = service.getBookByPage(category_id, pageNum);
		
		request.setAttribute("page", page);
		request.setAttribute("category_id", category_id);
		request.getRequestDispatcher("/manager/listbookbypage.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
