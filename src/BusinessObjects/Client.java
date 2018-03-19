package BusinessObjects;

import LocationObjects.Country;
import LocationObjects.ProvinceState;

public class Client {

	private int clientID;
	private Account account;
	private ProvinceState provinceState;
	private Country country;
	private ClientType clientType;
	private String companyName;
	private String address;
	private String postalZipCode;
	private String shippingAddress;

	public Client(int clientID, Account account, ProvinceState provinceState, Country country, ClientType clientType, String companyName, String address, String postalZipCode, String shippingAddress) {
		this.clientID = clientID;
		this.account = account;
		this.provinceState = provinceState;
		this.country = country;
		this.clientType = clientType;
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
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	public void setCountryID(Country country) {
		this.country = country;
	}
	
	public ClientType getClientTypeID() {
		return clientType;
	}

	public void setClientTypeID(ClientType clientType) {
		this.clientType = clientType;
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
}
