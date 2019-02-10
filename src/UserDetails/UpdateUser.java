package UserDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.DBConnector;
import Register.User;;

/**
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
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
		
		User user = new User();

		HttpSession session = request.getSession();
			
		user.setFirstName(request.getParameter("fname"));
		user.setLastName(request.getParameter("lname"));
		user.setMobileNumber(request.getParameter("MNum"));
		user.setEmail(request.getParameter("Email"));
		user.setPassword(request.getParameter("pass"));
		user.setConfirmPassword(request.getParameter("pass2"));

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		
		if (con == null) {
			out.write("Connection Not Established");
		} else {
			try {
				Statement st = con.createStatement();
				String sql = "select * from users where (uname = '"
						+ user.getEmail() + "'  email = '" + user.getEmail()
						+ "')";
				ResultSet rs = st.executeQuery(sql);
				
				Statement st2 = con.createStatement();
				String sql2 = "select * from admins where uname = '"
						+ user.getEmail() + "'  email = '" + user.getEmail()
						+ "')";
				ResultSet rs2 = st2.executeQuery(sql2);
				
				if (rs.next()) {
					Object message = " Email exist";
					request.setAttribute("emailExist", message);
					request.getRequestDispatcher("/getUser")
							.forward(request, response);
					
				}
				
				else if (rs2.next()) {
					Object message = "Email exist";
					request.setAttribute("emailExist", message);
					request.getRequestDispatcher("/getUser").forward(
							request, response);					
				}
				
				else if (!user.getPassword().equals(user.getConfirmPassword())) {
					Object message = "Password not maching";
					request.setAttribute("passMatchingErr", message);
					request.getRequestDispatcher("/getUser")
							.forward(request, response);
				}
				
				else if (!user.getEmail().matches(
						"^[A-Z0-9a-z._%+-]+@[A-Z0-9a-z]+\\.[A-Za-z]{2,6}$")) {
					Object message = "Use Standered email";
					request.setAttribute("emailErr", message);
					request.getRequestDispatcher("/getUser")
							.forward(request, response);
				}

				else {

					String sql3 = "update register_customer set "
							+ user.getFirstName() + "'," + "fname='"
							+ user.getLastName() + "'," + "lname='"
							+ user.getMobileNumber() + "'," + "MNum='"
							+ user.getEmail() + "'," + "email='"
							+ user.getPassword() + "'," + "pass='"
							+ user.getConfirmPassword() + "'," + "pass2='" +"where email='"+user.getEmail() +"'";
					
					Statement st1=con.createStatement();
					st1.executeUpdate(sql3);
					
					session.setAttribute("loggedAs", "register_customer");
					session.setAttribute("email", user.getEmail());
					session.setAttribute("pass", user.getPassword());
					
					
					request.getRequestDispatcher("/index.jsp").forward(request,response);
					
					
				}
			} catch (Exception e) {
				System.out.println("Got an exception");
				System.out.println(e.getMessage());
			}
		}

	}

}
