package Login;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.DBConnector;

/**
 * Servlet implementation class loginCheck
 */
public class loginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object dbpass;
	private String dbemail;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginCheck() {
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
	 * @param dbpass 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, String dbpass) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email").trim();
		String pass = request.getParameter("pass").trim();
		
		response.setContentType("text/html");
		PrintWriter write=response.getWriter();
		
		DBConnector db = new DBConnector();
		Connection conn = db.getConnection();
		
		if (conn == null){
			write.write("Connection Not Established");
		
		System.out.println("Done");}

		else {
			write.write("Connection Established");

			String message=null;	
			String sql = "select email,pass from register_customer where email='"+email+"'";
			
			String sal2 = "select email,pass from admin where email='"+email+"'";
			
		
			
			try {
				Statement st = (Statement) conn.createStatement();
				ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);
				
				Statement st2 = (Statement) conn.createStatement();
				ResultSet rs2 = ((java.sql.Statement) st2).executeQuery(sal2);
				
				
			
				while (rs.next()) {
					
					dbemail=(rs.getString(1));
					dbpass=(rs.getString(2));
					
				}

				if (dbemail.equals(email) && dbpass.equals(pass)) {
					HttpSession session = request.getSession();
					
					session.setAttribute("loggedAs", "register_customer");
					session.setAttribute("email", dbemail);
					session.setAttribute("pass", dbpass);
				
					
					
					message=(String)session.getAttribute("email");
					request.setAttribute("message", message);
					
					request.getRequestDispatcher("index/.jsp").forward(request,response);
					
				}
				
				

				else if ( dbemail.equals(email) && !dbpass.equals(pass)) {
					message="Incorrect password";
					request.setAttribute("message1", message);
					request.getRequestDispatcher("/login.jsp").forward(request,response);
				}
				
				
				
				else{
					
					while (rs2.next()) {

						dbemail = (rs2.getString(2));
						dbpass = (rs2.getString(3));
						
				}
					
				
					if (dbemail.equals(email)
							&& dbpass.equals(pass)) {
						HttpSession session = request.getSession();

						session.setAttribute("loggedAs", "admin");
						session.setAttribute("email", dbemail);
						session.setAttribute("pass", dbpass);
					

						message = (String) session.getAttribute("email");
						request.setAttribute("message", message);

						request.getRequestDispatcher("/index.jsp").forward(
								request, response);

					}

					else if (dbemail.equals(email)
							&& !dbpass.equals(pass)) {
						message = "Incorrect password";
						request.setAttribute("message1", message);
						request.getRequestDispatcher("/login.jsp").forward(
								request, response);
					}
				

				else {
					message="Cannot find user "+email;
					request.setAttribute("message1", message);
					request.getRequestDispatcher("/login.jsp").forward(request,response);
				}
			}		
					
					
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			}
		}
	}

	public Object getDbpass() {
		return dbpass;
	}

	public void setDbpass(Object dbpass) {
		this.dbpass = dbpass;
	}
}


