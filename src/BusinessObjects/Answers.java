package BusinessObjects;

public class Answers {
	
	public int getAnswerID() {
		return answerID;
	}

	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	private int answerID;
	private String answerText;
	private int weight;
	
	public Answers() {
		
	}
	
	public Answers(int answerID, String answerText, int weight) {
		this.answerID = answerID;
		this.answerText = answerText;
		this.weight = weight;
	}

}
