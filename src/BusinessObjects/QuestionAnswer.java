package BusinessObjects;

public class QuestionAnswer { 
	
	private int questionAnswerID;
	private Questions question;
	private Category category;	
	private Answers answer;
	private int questionnaireID;
	
	public Answers getAnswer() {
		return answer;
	}

	public void setAnswer(Answers answer) {
		this.answer = answer;
	}

	public int getQuestionnaireID() {
		return questionnaireID;
	}

	public void setQuestionnaireID(int questionnaireID) {
		this.questionnaireID = questionnaireID;
	}

	public void setQuestionAnswerID(int questionAnswerID) {
		this.questionAnswerID = questionAnswerID;
	}

	public QuestionAnswer() {};
	
	public QuestionAnswer(Questions question, Category category, Answers answer) {
		super();
		this.question = question;
		this.category = category;
		this.answer = answer;
	}

	public int getQuestionAnswerID() {
		return questionAnswerID;
	}
	
	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	

}
