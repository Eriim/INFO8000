package BusinessObjects;

import java.sql.Date;

public class Questionnaire {
	
	public Questionnaire() {};
	
	
	public Questionnaire( Date dateCompleted, Boolean isCompleted, Client client) {
		this.dateCompleted = dateCompleted;
		this.isCompleted = isCompleted;
		this.client = client;
	}


	private int questionnaireID;
	
	public int getQuestionnaireID() {
		return questionnaireID;
	}
	private Date dateCompleted;
	private Boolean isCompleted;
	private Client client;
	public Date getDateCompleted() {
		return dateCompleted;
	}
	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	public Boolean getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}


	public void setQuestionnaireID(int id) {
		this.questionnaireID = id;
		
	}
	
	

}
