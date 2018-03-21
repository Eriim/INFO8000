package Accounts;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Authentication.Hasher;
import BusinessObjects.Account;
import BusinessObjects.Client;
import BusinessObjects.Country;
import BusinessObjects.ProvinceState;
import Database.ConnectionHandler;
import Database.DAO;

/**
 * Servlet implementation class CreateClientServlet
 */
@WebServlet("/CreateClientServlet")
public class CreateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClientServlet() {
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
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("accountID"));
		int accountID = (int) session.getAttribute("accountID");
		
		String companyName = request.getParameter("companyName");
		
		String country = request.getParameter("country");
		String clientType = request.getParameter("clientType");
		String address = request.getParameter("address");
		String postalZipCode = request.getParameter("postalZipCode");
		String shippingAddress = request.getParameter("shippingAddress");
		String provinceState = request.getParameter("provinceState");
		
		Boolean error = false;
		String errorMsg = "";
		
		String canPostalCodeReg =  "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";
		String usZipRegex = "^[0-9]{5}(?:-[0-9]{4})?$";
		
		try {
			if(companyName.equals("")){
				error = true;
				errorMsg += "Please enter a company name. <br/>";
			}
			 if(address.equals("") || address.length() < 4){
				error = true;
				errorMsg += "Please enter a proper address. <br/>";
			}
			 if(postalZipCode.equals("") || postalZipCode.length() < 5){
				error = true;
				errorMsg += "Please enter a valid postal/zip code. <br/>";
			}
			 if(country.equals(""))
			{
				error = true;
				errorMsg += "Please choose a country. <br/>";
			}
			 if(country.equals("CAN") && !postalZipCode.matches(canPostalCodeReg))
			{
				error = true;
				errorMsg += "Please enter a valid postal code. <br/>";
			}
			 if(country.equals("USA") && !postalZipCode.matches(usZipRegex))
			{
				error = true;
				errorMsg += "Please enter a valid zip code. <br/>";
			}
			 if(address.equals("") || address.length() < 4){
				error = true;
				errorMsg += "Please enter a proper address. <br/>";
			}
			if(shippingAddress.equals("") || shippingAddress.length() < 4){
				error = true;
				errorMsg += "Please enter a proper shipping address. <br/>";
			}
			
			
		
			if(error) {
				request.setAttribute("error", errorMsg);
				request.getRequestDispatcher("/createClientAccount.jsp").forward(request, response);
			}
			else
			{
			ConnectionHandler handler = (ConnectionHandler)session.getAttribute("connection");
			Connection conn = DAO.OpenConnection("dwet", "password123");
			Account account = DAO.getAccount(accountID, conn);
			ProvinceState provinceStateTemp = new ProvinceState(1, provinceState);
			Country countryTemp = new Country(1, country);
			Client client = new Client(account, provinceStateTemp, countryTemp,  companyName, address, postalZipCode, shippingAddress);
			DAO.createClient(client, conn);;
			request.setAttribute("message", "Client " + account.getFirstName() + ", " + account.getLastName() + " created.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
