package Authentication;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DAO;
import Authentication.Hasher;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
	
		
		try {
				Connection conn;
				conn = DAO.OpenConnection(username, password);
				DAO.createAccount("eric", "hashPass", "salt", "email", "phone", "firstN", "lastN", conn);
				//get salt
				
				String salt = DAO.getSalt(username, conn);
				
				Hasher hash = new Hasher();
				String hashed = hash.HashedPassword(password, salt);
				
				String hashPass = DAO.getHashPass(username, conn);
				
				Boolean isCorrectPass = hash.verifyHash(hashPass, hashed);
				
				if(isCorrectPass) {
					request.setAttribute("username", username);
					request.setAttribute("hashPass", hashPass);
					request.getRequestDispatcher("./index.jsp").forward(request, response);
				}
				else {
					request.setAttribute("error", "Incorrect credentials");
					request.getRequestDispatcher("./login.jsp").forward(request, response);
				}			
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
