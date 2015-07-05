package feng.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import feng.domain.Cart;
import feng.domain.User;
import feng.service.BusinessServices;

public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user==null){
			response.getWriter().write("请先登陆！！");
			return;
		}
		
		BusinessServices service = new BusinessServices();
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		service.addOrder(cart, user);
		
		response.getWriter().write("您好！！系统已成功处理您的订货请求，请等待发货！！");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
