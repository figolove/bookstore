package feng.dao;

import java.util.List;

import feng.domain.Order;
import feng.domain.User;

public interface OrderDao {
	
	public void addOrder(Order order);
	
	public Order find(String id);
	
	public List getAll(boolean state);
	
	public void updateOrderState(String id);
	
	public List find(User user);
	
}
