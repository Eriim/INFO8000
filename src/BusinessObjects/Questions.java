package BusinessObjects;

public class Questions {
	
	
	
	private int questionID;
	private int categoryID;
	private String questionText;
	
	public Questions() {
		
	}
	
	public Questions(int questionID,  int categoryID, String questionText ) {
		this.questionID = questionID;
		this.categoryID = categoryID;
		this.questionText = questionText;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	

}
