package feng.web.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import feng.domain.Order;
import feng.service.BusinessServices;

public class ConfirmOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String order_id = request.getParameter("order_id");
		BusinessServices service = new BusinessServices();
		service.updateOrderState(order_id);
		
		response.getWriter().write("�������޸�Ϊ����״̬���뼰ʱ������������");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
