package feng.dao;

import java.util.List;

import feng.domain.Book;

public interface BookDao {
	
	public void addBook(Book book);
	
	public Book find(String id);
	
	public int getTotalRecord(String category_id);
	
	public List getBookByPage(String category_id,int startindex,int pagesize);
	
	public int getTotalRecord();
	
	public List getBookByPage(int startindex,int pagesize);

	public void deleteBook(String book_name);
	
	
}
