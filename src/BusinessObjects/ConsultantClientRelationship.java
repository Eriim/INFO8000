package BusinessObjects;

import java.sql.Date;

public class ConsultantClientRelationship {
	
	
	public ConsultantClientRelationship(int consultantClientID, Client client, Consultant consultant, Date dateInitiated)
	{
		this.consultantClientID = consultantClientID;
		this.client = client;
		this.consultant = consultant;
		this.dateInitiated = dateInitiated;
	}
	
	private int consultantClientID;
	private Client client;
	private Consultant consultant;
	private Date dateInitiated;
	
	public int getConsultantClientID() {
		return consultantClientID;
	}
	public void setConsultantClientID(int consultantClientID) {
		this.consultantClientID = consultantClientID;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Date getDate() {
		return dateInitiated;
	}
	public void setDate(Date date) {
		this.dateInitiated = date;
	}
	public Consultant getConsultant() {
		return consultant;
	}
	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}

}
