package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.derby.jdbc.ClientDriver;

import BusinessObjects.Account;
import BusinessObjects.Client;
import BusinessObjects.Consultant;

public class DAO {

	private static final String dbUrl = "jdbc:derby://localhost:1527/BMATDB";

	public static Connection OpenConnection(String CONNECTION_USER, String CONNECTION_PASSWORD)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Properties tempConnProp = new Properties();
		// tempConnProp.put("username", CONNECTION_USER);
		// tempConnProp.put("password", CONNECTION_PASSWORD);
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection tempConn = DriverManager.getConnection(dbUrl);
		DriverManager.registerDriver(new ClientDriver());
		tempConn.setAutoCommit(false);
		tempConn.createStatement().executeUpdate("SET SCHEMA APP");

		System.out.println("Connection to database opened");
		return tempConn;

	}

	private static void CloseConnection() {
		try {
			DriverManager.getConnection(dbUrl + ";shutdown=true");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changePassword(String username, String hashedPass, String salt, Connection tempConnection ) throws SQLException{
		
		String tempSQLInsertStatement = "UPDATE ACCOUNT SET hashPass = '" + hashedPass + "', salt = '" + salt + "' WHERE username = '" + username + "'";
		PreparedStatement tempPreparedStatement = tempConnection.prepareStatement(tempSQLInsertStatement);
		System.out.println("Password changed for " + username);
		tempPreparedStatement.execute();
		tempConnection.commit();	
		
	}
	
	public static Boolean isCorrectEmail(String username, String enteredEmail, Connection tempConnection) throws SQLException{
		Boolean isEmail = false;
		String accountEmail = "";
		
		String tempSQLSelectQuery = "SELECT email FROM ACCOUNT WHERE username='" + username + "'";
		PreparedStatement tempPreparedStatement = tempConnection.prepareStatement(tempSQLSelectQuery);
		ResultSet tempResultSet = tempPreparedStatement.executeQuery();
		if (tempResultSet.next()) {
			accountEmail = tempResultSet.getString("EMAIL");
			System.out.println(accountEmail + "....entered:" + enteredEmail);
			if(accountEmail.equals(enteredEmail)) {
				isEmail = true;
				System.out.println("Email is correct.");
			}
		
		}
		else
		{
			System.out.println("Email is false.");
		}
		
		
	
		return isEmail;
	}

	public static String getSalt(String username, Connection tempConnection) throws SQLException {
		String salt = null;
		String tempSQLSelectQuery = "SELECT salt FROM ACCOUNT WHERE username='" + username + "'";
		PreparedStatement tempPreparedStatement = tempConnection.prepareStatement(tempSQLSelectQuery);
		ResultSet tempResultSet = tempPreparedStatement.executeQuery();
		while (tempResultSet.next()) {
			salt = tempResultSet.getString("SALT");
		}
		System.out.println("Salt returned as string.");
		return salt;

	}
	
	public static Boolean usernameExists(String username, Connection tempConnection) throws SQLException {
		
		String tempSQLSelectQuery = "SELECT accountID FROM ACCOUNT WHERE username='" + username + "'";
		PreparedStatement tempPreparedStatement = tempConnection.prepareStatement(tempSQLSelectQuery);
		ResultSet tempResultSet = tempPreparedStatement.executeQuery();
		if (tempResultSet.next()) {
			System.out.println("User exists already");
			return true;

		}else {
			System.out.println("User does not exist");
			return false;
		}

	}
	
	public static int getAccountID(String username, Connection tempConnection) throws SQLException {
		int accountID  = 0;
		String tempSQLSelectQuery = "SELECT accountID FROM ACCOUNT WHERE username='" + username + "'";
		PreparedStatement tempPreparedStatement = tempConnection.prepareStatement(tempSQLSelectQuery);
		ResultSet tempResultSet = tempPreparedStatement.executeQuery();
		while (tempResultSet.next()) {
			accountID = tempResultSet.getInt("ACCOUNTID");
		}
		System.out.println("Account ID returned as int.");
		return accountID;

	}
	
	public static Account getAccount(int accountID, Connection tempConnection) throws SQLException {
		Account account  = new Account();
		String tempSQLSelectQuery = "SELECT * FROM ACCOUNT WHERE accountID=" + accountID;
		PreparedStatement tempPreparedStatement = tempConnection.prepareStatement(tempSQLSelectQuery);
		ResultSet tempResultSet = tempPreparedStatement.executeQuery();
		while (tempResultSet.next()) {
			account.setAccountID(tempResultSet.getInt("ACCOUNTID"));
			account.setUsername(tempResultSet.getString("USERNAME"));
			account.setHashPass(tempResultSet.getString("HASHPASS"));
			account.setSalt(tempResultSet.getString("SALT"));
			account.setEmail(tempResultSet.getString("EMAIL"));
			account.setPhone(tempResultSet.getString("PHONENUMBER"));
			account.setFirstName(tempResultSet.getString("FIRSTNAMECONTACT"));
			account.setLastName(tempResultSet.getString("LASTNAMECONTACT"));
		}
		System.out.println("Account returned as account");
		return account;

	}

	public static String getHashPass(String username, Connection tempConnection) throws SQLException {
		String hashPass = null;
		String tempSQLSelectQuery = "SELECT hashPass FROM ACCOUNT WHERE username='" + username +"'";
		PreparedStatement tempPreparedStatement = tempConnection.prepareStatement(tempSQLSelectQuery);
		ResultSet tempResultSet = tempPreparedStatement.executeQuery();
		while (tempResultSet.next()) {
			hashPass = tempResultSet.getString("HASHPASS");
		}
		System.out.println("Hashed password returned as string");
		System.out.println(hashPass);
		return hashPass;
	}

	public static void createAccount(Account account, Connection tempConnection) throws SQLException {
		String tempSQLInsertStatement = "INSERT INTO ACCOUNT (username, hashPass, salt, email, phoneNumber, firstNameContact, lastNameContact)"
				+ " VALUES('" + account.getUsername() + "', '" + account.getHashPass() + "', '" + account.getSalt()
				+ "', '" + account.getEmail() + "', '" + account.getPhone() + "', '" + account.getFirstName() + "', '"
				+ account.getLastName() + "')";
		PreparedStatement tempPreparedStatement = tempConnection.prepareStatement(tempSQLInsertStatement);
		System.out.println("Base account created");
		tempPreparedStatement.execute();
		tempConnection.commit();
	}

	public static void createConsultant(Consultant consultant, Connection tempConnection) throws SQLException {
		String tempSQLInsertStatement = "INSERT INTO CONSULTANT (accountID, workPhone, isAdmin)" + " VALUES("
				+ consultant.getAccount().getAccountID() + ", '" + consultant.getWorkPhone() + "', '"
				+ consultant.getIsAdmin() + "')";
		PreparedStatement tempPreparedStatement = tempConnection.prepareStatement(tempSQLInsertStatement);
		System.out.println("Consultant account created.");
		tempPreparedStatement.execute();
		tempConnection.commit();
	}

	public static void createClient(Client client, Connection tempConnection) throws SQLException {
		String tempSQLInsertStatement = "INSERT INTO CLIENT (accountID, provinceStateID, countryID, "
				+ "companyName, address, postalZipCode, shippingAddress )" + " VALUES("
				+ client.getAccount().getAccountID() + ", " + client.getProvinceState().getProvinceStateID() + ", "
				+ client.getCountry().getCountryID() + ", '" + client.getCompanyName() + "', '" + client.getAddress() + "', '" + client.getPostalZipCode()
				+ "' , '" + client.getShippingAddress() + "')";
		System.out.println(tempSQLInsertStatement);
		PreparedStatement tempPreparedStatement = tempConnection.prepareStatement(tempSQLInsertStatement);
		System.out.println("Client account created.");
		tempPreparedStatement.execute();
		tempConnection.commit();
	}

}
