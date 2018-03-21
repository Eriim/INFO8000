package Accounts;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Authentication.Hasher;
import BusinessObjects.Account;
import Database.ConnectionHandler;
import Database.DAO;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Account account = new Account();
		
	
		String password = request.getParameter("password");
		String confirmation = request.getParameter("confirmation");
		String accountType = request.getParameter("accountType");
		
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String firstName = request.getParameter("firstN");
		String lastName = request.getParameter("lastN");
		
		Boolean error = false;
		String errorMsg = "";
		
		try {
			if(userName.length() < 6)
			{
				error = true;
				errorMsg += "Username must be at least 6 characters long!<br/>";
			}
			
			if(!password.equals(confirmation))
			{
				error = true;
				errorMsg += "Passwords do not match!<br/>";
			}
			 if(!email.contains("@") || email.length() < 3)
			{
				error = true;
				errorMsg += "Email be a valid address!<br/>";
			}
			if(phone.length() < 10 || !phone.matches("^[0-9]+$"))
			{
				error = true;
				errorMsg += "Phone must be a valid number!<br/>";
			}
			if(firstName == "")
			{
				error = true;
				errorMsg += "Please enter a first name!<br/>";
			}
			if(lastName == "")
			{
				error = true;
				errorMsg += "Please enter a last name!<br/>";
			}
			
			if(!error) {
				
				account.setUsername(userName);
				account.setEmail(email);
				account.setPhone(phone);
				account.setFirstName(firstName);
				account.setLastName(lastName);
					
	
				HttpSession session = request.getSession();
				ConnectionHandler handler = (ConnectionHandler)session.getAttribute("connection");
				Connection conn = DAO.OpenConnection("eric", "password");
				
				Hasher hasher = new Hasher();
				account.setSalt(hasher.genSalt());
				account.setHashPass(hasher.HashedPassword(password, account.getSalt()));
				DAO.createAccount(account, conn);
				
				int accountID = DAO.getAccountID(account.getUsername(), conn);
				session.setAttribute("accountID", accountID);
				request.setAttribute("name", account.getFirstName() + ", " + account.getLastName());
				System.out.println(accountID);
				
	
				if(accountType.equals("Client")) {
					request.getRequestDispatcher("/createClientAccount.jsp").forward(request, response);
				}
				if(accountType.equals("Consultant")) {
					request.getRequestDispatcher("/createConsultantAccount.jsp").forward(request, response);
				}
			}
			else {
				System.out.println("Errors!");
				request.setAttribute("error", errorMsg);
				request.getRequestDispatcher("/createAccount.jsp").forward(request, response);

				
				
			}
			
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
