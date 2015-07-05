package feng.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cart {
	
	private Map map = new HashMap();
	private double totalprice = 0;
	
	public void add(Book book){
		CartItem item = (CartItem) map.get(book.getId());
		if(item==null){
			item = new CartItem();
			item.setBook(book);
			item.setQuantity(1);
			map.put(book.getId(), item);
		}else{
			item.setQuantity(item.getQuantity()+1);
		}
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public double getTotalprice() {
		
		this.totalprice = 0;
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			CartItem item = (CartItem) map.get(it.next());
			this.totalprice = this.totalprice + item.getTotalprice();
		}
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	
	
	
	
	
	
}
