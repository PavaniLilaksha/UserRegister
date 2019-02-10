package Register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.DBConnector;

import java.io.File;

/**
 * Servlet implementation class register
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		
		user.setFirstName(request.getParameter("fname"));
		user.setLastName(request.getParameter("lname"));
		user.setMobileNumber(request.getParameter("MNum"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("pass"));
		user.setConfirmPassword(request.getParameter("pass2"));
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.print(user.getFirstName());
		
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		
		if(con==null){
			out.write("Connection Not Established");
		
		}else {
			try {
				Statement st = con.createStatement();
				String sql = "select * from register_customer where email = '"
						+ user.getEmail() + "' or pass = '" + user.getPassword()
						+ "'";
				ResultSet rs = st.executeQuery(sql);
				
				if (rs.next()) {
					Object message = " Email exist";
					request.setAttribute("emailExist", message);
					request.getRequestDispatcher("/register.jsp").forward(
							request, response);
				}
				
				else if (!user.getPassword().equals(user.getConfirmPassword())) {
					Object message = "Password not maching";
					request.setAttribute("passwordMatchingErr", message);
					request.getRequestDispatcher("/register.jsp").forward(
							request, response);
				}
				
				else if (!user.getEmail().matches(
						"^[A-Z0-9a-z._%+-]+@[A-Z0-9a-z]+\\.[A-Za-z]{2,6}$")) {
					Object message = "Use Standered email";
					request.setAttribute("emailErr", message);
					request.getRequestDispatcher("/register.jsp").forward(
							request, response);
				}
				
				else {

					String sql2 = "insert into register_customer (fname,lname,MNum,email,pass,pass2,gender)"
							+ "values(?,?,?,?,?,?,?)";

					
					PreparedStatement pre = con.prepareStatement(sql2);
					
					pre.setString(1, user.getFirstName());
					pre.setString(2, user.getLastName());
					pre.setString(3, user.getMobileNumber());
					pre.setString(4, user.getEmail());
					pre.setString(5, user.getPassword());
					pre.setString(6, user.getConfirmPassword());
					pre.setString(7, "male");
		
					pre.execute();
					
					HttpSession session = request.getSession();
					
					session.setAttribute("fname", user.getFirstName());
					session.setAttribute("lname", user.getLastName());
					session.setAttribute("MNum", user.getMobileNumber());
					session.setAttribute("email", user.getEmail());
					session.setAttribute("pass", user.getPassword());
					session.setAttribute("pass2", user.getConfirmPassword());
					
					
					
					request.getRequestDispatcher("/getUser.jsp").forward(request,
							response);
					
					
		
		}
		
			}catch (Exception e) {
				System.out.println("Got an exception");
				System.out.println(e.getMessage());
			}
			
		}
		
	}
}

