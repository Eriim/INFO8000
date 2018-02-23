package LocationObjects;

public class ProvinceState {
	
	public ProvinceState(){};
	
	public ProvinceState(int provinceStateID, String name){
		this.provinceStateID = provinceStateID;
		this.name = name;
		
	}
	
	private int provinceStateID;
	private String name;
	
	public int getProvinceStateID() {
		return provinceStateID;
	}
	public void setProvinceStateID(int provinceStateID) {
		this.provinceStateID = provinceStateID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
