package Database;

import java.sql.Connection;

import BusinessObjects.Account;

public class ConnectionHandler {
	
	private Connection connection;
	private Account user;
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
