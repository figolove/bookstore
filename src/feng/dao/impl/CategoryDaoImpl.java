package feng.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import feng.dao.CategoryDao;
import feng.dao.exception.DaoException;
import feng.domain.Category;

public class CategoryDaoImpl implements CategoryDao {

	private DataSource dataSource;
	public CategoryDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void addCategory(Category category) {
		try{
			QueryRunner runner = new QueryRunner(dataSource);
			String sql = "insert into category(id,name,description) values(?,?,?)";
			Object params[] = {category.getId(),category.getName(),category.getDescription()};
			runner.update(sql, params);
		}catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}
	}

	public List getAllCategory() {
		try{
			QueryRunner runner = new QueryRunner(dataSource);
			String sql = "select * from category";
			return (List) runner.query(sql, new BeanListHandler(Category.class));
		}catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}
	}
	
	public void deleteCategory(String category_name){
		try{
			QueryRunner runner = new QueryRunner(dataSource);
			String sql = "delete from category where name=?";
			runner.update(sql, category_name);
		}catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}
	}
	
}
