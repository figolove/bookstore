package feng.dao;

import java.util.List;

import feng.domain.Category;

public interface CategoryDao {
	
	public void addCategory(Category category);
	
	public List getAllCategory();
	
	public void deleteCategory(String category_name);
	
}
