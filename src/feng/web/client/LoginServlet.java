package feng.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import feng.domain.User;
import feng.service.BusinessServices;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		BusinessServices service = new BusinessServices();
		User user = service.findUser(name, password);
		if(user!=null){
			request.getSession().setAttribute("user", user);
		}else{
			request.setAttribute("message", "<script>alert('用户名或密码不对！！')</script>");
		}
		request.getRequestDispatcher("/head.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
