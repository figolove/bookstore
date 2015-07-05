package feng.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import feng.dao.BookDao;
import feng.dao.exception.DaoException;
import feng.domain.Book;

public class BookDaoImpl implements BookDao {

	private DataSource dataSource;
	public BookDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public void addBook(Book book) {
		try{
			QueryRunner runner = new QueryRunner(dataSource);
			String sql = "insert into book(id,name,author,price,image,description,category_id) values(?,?,?,?,?,?,?)";
			Object params[] = {book.getId(),book.getName(),book.getAuthor(),book.getPrice(),book.getImage(),book.getDescription(),book.getCategory_id()};
			runner.update(sql, params);
		}catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}
	}

	public Book find(String id) {
		try{
			QueryRunner runner = new QueryRunner(dataSource);
			String sql = "select * from book where id=?";
			return (Book) runner.query(sql, id, new BeanHandler(Book.class));
		}catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}
	}

	public List getBookByPage(String category_id, int startindex, int pagesize) {
		try{
			QueryRunner runner = new QueryRunner(dataSource);
			String sql = "select * from book where category_id=? limit ?,?";
			Object params[] = {category_id,startindex,pagesize};
			return (List) runner.query(sql, params, new BeanListHandler(Book.class));
		}catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}
	}

	public int getTotalRecord(String category_id) {
		try{
			QueryRunner runner = new QueryRunner(dataSource);
			String sql = "select count(*) from book where category_id=?";
			Object result[] = (Object[]) runner.query(sql, category_id, new ArrayHandler());
			return Integer.parseInt(result[0].toString());
		}catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}
	}

	public List getBookByPage(int startindex, int pagesize) {
		try{
			QueryRunner runner = new QueryRunner(dataSource);
			String sql = "select * from book limit ?,?";
			Object params[] = {startindex,pagesize};
			return (List) runner.query(sql, params, new BeanListHandler(Book.class));
		}catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}
	}

	public int getTotalRecord() {
		try{
			QueryRunner runner = new QueryRunner(dataSource);
			String sql = "select count(*) from book";
			Object result[] = (Object[]) runner.query(sql, new ArrayHandler());
			return Integer.parseInt(result[0].toString());
		}catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}
	}

	@Override
	public void deleteBook(String book_name) {
		try{
			QueryRunner runner = new QueryRunner(dataSource);
			String sql = "delete from book where name=?";
			runner.update(sql, book_name);
		}catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}
		
	}
}
