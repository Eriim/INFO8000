package Authentication;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.ConnectionHandler;
import Database.DAO;


/**
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordServlet() {
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
		try {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		
		Boolean error = false;
		String errorMsg = "";
		
		HttpSession session = request.getSession();
		ConnectionHandler handler = (ConnectionHandler)session.getAttribute("connection");
		Connection conn = DAO.OpenConnection("eric", "password");
		

		
		if(username.equals("") || email.equals(""))
		{
			error = true;
			errorMsg = "Please enter credentials";
			
		}
		
		if(!DAO.isCorrectEmail(username, email, conn) || !DAO.usernameExists(username, conn))
		{
			error = true;
			errorMsg = "Incorrect credentials";
		}
		
		if(!error)
		{	
									
		   	  String to = email;
		      String from = "sixschangereadiness@gmail.com";
		      String host = "localhost";
		
		   try{

		        Properties props = new Properties();
		        props.put("mail.smtp.host", "smtp.gmail.com"); // for gmail use smtp.gmail.com
		        props.put("mail.smtp.auth", "true");
		        props.put("mail.debug", "true"); 
		        props.put("mail.smtp.starttls.enable", "true");
		        props.put("mail.smtp.port", "465");
		        props.put("mail.smtp.socketFactory.port", "465");
		        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		        props.put("mail.smtp.socketFactory.fallback", "false");

		        Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {

		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication( from , "sixscr123");
		            }
		        });

		        mailSession.setDebug(true); // Enable the debug mode

		        Message msg = new MimeMessage( mailSession );

		        //--[ Set the FROM, TO, DATE and SUBJECT fields
		        msg.setFrom( new InternetAddress(from) );
		        msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse(to) );
		        msg.setSentDate( new Date());
		        msg.setSubject( "Six S Solutions - Password Reset" );
		        
		        Hasher hash = new Hasher();
		        String generatedPassword = hash.generateString();
		        String salt = hash.genSalt();
		        String hashedPassword = hash.hashedPassword(generatedPassword, salt);
		       
		        
		        DAO.changePassword(username, hashedPassword,salt, conn);
		        
		        //--[ Create the body of the mail
		        msg.setText( "Hello, your password on the Six S Solutions Change Readiness has been changed to: " + generatedPassword);

		        //--[ Ask the Transport class to send our mail message
		        Transport.send( msg );
		        
		    	request.setAttribute("message", "An email has been sent to " + email + " with your new password.");
				request.getRequestDispatcher("./login.jsp").forward(request, response);

		    }catch(Exception E){
		        System.out.println( "Oops something has gone wrong with sending email!");
		        System.out.println( E );
					    }
					   			
		}
		else{
			
			request.setAttribute("error", errorMsg);
			request.getRequestDispatcher("./forgotPassword.jsp").forward(request, response);
			
			
		}
		
		}catch(Exception e) {
			System.out.println(e.toString());
		}
			}
		
									
}



