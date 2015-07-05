package feng.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import feng.dao.BookDao;
import feng.dao.CategoryDao;
import feng.dao.OrderDao;
import feng.dao.UserDao;
import feng.dao.impl.BookDaoImpl;
import feng.dao.impl.CategoryDaoImpl;
import feng.dao.impl.OrderDaoImpl;
import feng.dao.impl.UserDaoImpl;
import feng.domain.Book;
import feng.domain.Cart;
import feng.domain.CartItem;
import feng.domain.Category;
import feng.domain.Order;
import feng.domain.OrderItem;
import feng.domain.Page;
import feng.domain.User;
import feng.util.JdbcUtils;
import feng.util.Utils;

public class BusinessServices {
	
	/**添加分类**/
	public void addCategory(Category category){
		CategoryDao dao = new CategoryDaoImpl(JdbcUtils.getDataSource());
		dao.addCategory(category);
	}
	
	/**删除分类**/
	public void deleteCategory(String category_name){
		CategoryDao dao = new CategoryDaoImpl(JdbcUtils.getDataSource());
		dao.deleteCategory(category_name);
	}
	
	/**删除书本**/
	public void deleteBook(String book_name) {
		BookDao dao = new BookDaoImpl(JdbcUtils.getDataSource());
		dao.deleteBook(book_name);
	}
	
	/**得到所有分类信息**/
	public List getALlCategory(){
		CategoryDao dao = new CategoryDaoImpl(JdbcUtils.getDataSource());
		return dao.getAllCategory();
	}
	
	/**添加书籍**/
	public void addBook(Book book){
		BookDao dao = new BookDaoImpl(JdbcUtils.getDataSource());
		dao.addBook(book);
	}
	
	/**得到分类下面的书籍分页数据**/
	public Page getBookByPage(String category_id,String pageNum){
		
		BookDao dao = new BookDaoImpl(JdbcUtils.getDataSource());
		int totalrecord = dao.getTotalRecord(category_id);
		Page page = null;
		
		if(pageNum==null){
			page = new Page(totalrecord,1);
		}else{
			page = new Page(totalrecord,Integer.parseInt(pageNum));
		}
		List list = dao.getBookByPage(category_id, page.getStartindex(), page.getPagesize());
		page.setList(list);
		return page;
	}
	
	/**得到分类下面的书籍分页数据**/
	public Page getBookByPage(String pageNum){
		
		BookDao dao = new BookDaoImpl(JdbcUtils.getDataSource());
		int totalrecord = dao.getTotalRecord();
		Page page = null;
		
		if(pageNum==null){
			page = new Page(totalrecord,1);
		}else{
			page = new Page(totalrecord,Integer.parseInt(pageNum));
		}
		List list = dao.getBookByPage(page.getStartindex(), page.getPagesize());
		page.setList(list);
		return page;
	}

	/**向购物车中添加商品**/
	public void buyBook(String bookid, Cart cart) {
		
		BookDao dao = new BookDaoImpl(JdbcUtils.getDataSource());
		Book book = dao.find(bookid);
		cart.add(book);
	}
	
	/**注册用户**/
	public void addUser(User user){
		
		UserDao dao = new UserDaoImpl(JdbcUtils.getDataSource());
		dao.add(user);
	}
	
	/**用户登陆**/
	public User findUser(String name,String password){
		UserDao dao = new UserDaoImpl(JdbcUtils.getDataSource());
		return dao.find(name, password);
	}
	
	/**保存用户订单**/
	public void addOrder(Cart cart,User user){
		if(cart==null){
			throw new IllegalArgumentException("购物车为空！！");
		}
		
		Order order = new Order();
		order.setId(Utils.makeId());
		order.setOrdertime(new Date());
		order.setPrice(cart.getTotalprice());
		order.setState(false);
		order.setUser(user);
		
		Set set = new HashSet();
		Iterator it = cart.getMap().keySet().iterator();
		while(it.hasNext()){
			CartItem item = (CartItem) cart.getMap().get(it.next());
			OrderItem oitem = new OrderItem();
			oitem.setBook(item.getBook());
			oitem.setId(Utils.makeId());
			oitem.setPrice(item.getTotalprice());
			oitem.setQuantity(item.getQuantity());
			set.add(oitem);
		}
		order.setOrderitems(set);
		
		OrderDao dao = new OrderDaoImpl(JdbcUtils.getDataSource());
		dao.addOrder(order);
	}
	
	/**查看所有订单**/
	public List getAllOrder(boolean state){
		OrderDao dao = new OrderDaoImpl(JdbcUtils.getDataSource());
		return dao.getAll(state);
	}
	
	/**根据ID得到某一个订单**/
	public Order findOrder(String order_id){
		OrderDao dao = new OrderDaoImpl(JdbcUtils.getDataSource());
		return dao.find(order_id);
	}
	
	/**根据ID把订单置为已发货状态**/
	public void updateOrderState(String order_id){
		OrderDao dao = new OrderDaoImpl(JdbcUtils.getDataSource());
		dao.updateOrderState(order_id);
	}
	
	public List findUserOrder(User user){
		OrderDao dao = new OrderDaoImpl(JdbcUtils.getDataSource());
		return dao.find(user);
	}
}
