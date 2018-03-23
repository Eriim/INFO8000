package BusinessObjects;

public class Category {
	
	private int categoryID;
	private String categoryText;
	
	public Category() {
		
	}
	
	public Category(int categoryID, String categoryText) {
		this.categoryID = categoryID;
		this.categoryText = categoryText;
	}
	
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryText() {
		return categoryText;
	}
	public void setCategoryText(String categoryText) {
		this.categoryText = categoryText;
	}
	
	
}
