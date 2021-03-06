package BusinessObjects;

public class Client {

	private int clientID;
	private Account account;
	private ProvinceState provinceState;
	private Country country;
	private String companyName;
	private String address;
	private String postalZipCode;
	private String shippingAddress;

	public Client(Account account, ProvinceState provinceState, Country country,  String companyName, String address, String postalZipCode, String shippingAddress) {
		this.account = account;
		this.provinceState = provinceState;
		this.country = country;
		this.companyName = companyName;
		this.address = address;
		this.postalZipCode = postalZipCode;
		this.shippingAddress = shippingAddress;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	
	public ProvinceState getProvinceState() {
		return provinceState;
	}

	public void setProvinceState(ProvinceState provinceState) {
		this.provinceState = provinceState;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	

	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPostalZipCode() {
		return postalZipCode;
	}

	public void setPostalZipCode(String postalZipCode) {
		this.postalZipCode = postalZipCode;
	}
	
	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
