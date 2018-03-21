package Accounts;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessObjects.Account;
import BusinessObjects.Consultant;
import Database.DAO;

/**
 * Servlet implementation class CreateConsultant
 */
@WebServlet("/CreateConsultantServlet")
public class CreateConsultantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateConsultantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int accountID = Integer.parseInt(request.getParameter("accountID"));
		String workPhone = request.getParameter("workPhone");
		Boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));
		
		Boolean error = false;
		String errorMsg = "";
		
		try {
			
			if(workPhone.length() < 10 || !workPhone.matches("^[0-9]+$"))
			{
				error = true;
				errorMsg = "Please enter a valid work phone <br/>";
				request.setAttribute("error", errorMsg);
				request.getRequestDispatcher("createConsultantAccount.jsp").forward(request, response);
			}
			else
			{
				Connection conn = DAO.OpenConnection("eric", "password");
				Account account = DAO.getAccount(accountID, conn);
				account.setAccountID(accountID);
				System.out.println(1);
				
				Consultant consultant = new Consultant(account, workPhone, isAdmin);
				DAO.createConsultant(consultant, conn);
				System.out.println(2);
				request.setAttribute("message", "Consultant: " + account.getFirstName() + ", " + account.getLastName() + " created.");
				request.getRequestDispatcher("./index.jsp").forward(request, response);
				
			}
			
			
		

			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
