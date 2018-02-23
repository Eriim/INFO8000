package LocationObjects;

public class Country {
	
	public Country(){};
	
	public Country(int countryID, String country)
	{
		this.countryID = countryID;
		this.country = country;
	}
	
	private int countryID;
	private String country;
	
	public int getCountryID() {
		return countryID;
	}
	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	

}
