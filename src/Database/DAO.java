package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.derby.jdbc.ClientDriver;

public class DAO {
	

	private static final String dbUrl = "jdbc:derby://localhost:1527/C:/CapstoneDB";

	public static Connection OpenConnection(String CONNECTION_USER, String CONNECTION_PASSWORD)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Properties tempConnProp = new Properties();
		//tempConnProp.put("username", CONNECTION_USER);
		//tempConnProp.put("password", CONNECTION_PASSWORD);
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

	public static String getSalt(String username, Connection tempConnection) throws SQLException {
		String salt = null;
		String tempSQLSelectQuery = "SELECT salt FROM ACCOUNT WHERE username='" + username +"'";
		PreparedStatement tempPreparedStatement = tempConnection.prepareStatement(tempSQLSelectQuery);
		ResultSet tempResultSet = tempPreparedStatement.executeQuery();
		while (tempResultSet.next()) {
			salt = tempResultSet.getString("SALT");
		}
		System.out.println("Salt returned as string.");
		return salt;
		
	}

	public static String getHashPass(String username, Connection tempConnection) throws SQLException {
		String hashPass = null;
		String tempSQLSelectQuery = "SELECT hashPass FROM ACCOUNT WHERE username=" + username;
		PreparedStatement tempPreparedStatement = tempConnection.prepareStatement(tempSQLSelectQuery);
		ResultSet tempResultSet = tempPreparedStatement.executeQuery();
		while (tempResultSet.next()) {
			hashPass = tempResultSet.getString("HASHPASS");
		}
		System.out.println("Hashed password returned as string");
		return hashPass;
	}

	public static void createAccount(String username, String hashPass, String salt, String email, String phone,
			String firstN, String lastN, Connection tempConnection) throws SQLException {
		String tempSQLInsertStatement = "INSERT INTO ACCOUNT (username, hashPass, salt, email, phoneNumber, firstNameContact, lastNameContact)"
				+ " VALUES('" + username + "', '" + hashPass + "', '" + salt + "', '" + email + "', '" + phone + "', '"
				+ firstN + "', '" + lastN + "')";
		PreparedStatement tempPreparedStatement = tempConnection.prepareStatement(tempSQLInsertStatement);
		System.out.println("Base account created");
		tempPreparedStatement.execute();
	}

	public static void createConsultant(int accountID, String workPhone, Boolean isAdmin, Connection tempConnection)
			throws SQLException {
		String tempSQLInsertStatement = "INSERT INTO CONSULTANT (accountID, workPhone, isAdmin)" + " VALUES("
				+ accountID + ", '" + workPhone + "', '" + isAdmin + "')";
		PreparedStatement tempPreparedStatement = tempConnection.prepareStatement(tempSQLInsertStatement);
		System.out.println("Consultant account created.");
		tempPreparedStatement.executeQuery();
	}

	public static void createClient(int accountID, int provinceStateID, int countryID, int clientTypeID,
			String companyName, String address, String postalZipCode, String shippingAddress, Connection tempConnection)
			throws SQLException {
		String tempSQLInsertStatement = "INSERT INTO CLIENT (accountID, provinceStateID, countryID, clientTypeID"
				+ "companyName, address, postalZipCode, shippingAddress )" + " VALUES(" + accountID + ", "
				+ provinceStateID + ", " + countryID + ", " + clientTypeID + ", '" + companyName + "', '" + "' , '"
				+ address + "', '" + postalZipCode + "' , '" + shippingAddress + "' , ')";
		PreparedStatement tempPreparedStatement = tempConnection.prepareStatement(tempSQLInsertStatement);
		System.out.println("Client account created.");
		tempPreparedStatement.executeQuery();
	}

}
