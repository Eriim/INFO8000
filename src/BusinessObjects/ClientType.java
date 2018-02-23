package BusinessObjects;

public class ClientType {
	
	public ClientType(){};
	public ClientType(int typeID, String type){
		this.typeID = typeID;
		this.type= type;
		
	}
	
	private int typeID;
	private String type;
	
	
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
