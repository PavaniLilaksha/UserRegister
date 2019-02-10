package Register;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Admin.Admin;
import Login.DBConnector;

/**
 * Servlet implementation class RegisterAdmin
 */
public class RegisterAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAdmin() {
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
		
		Admin admin = Admin.getInstance();
		
		System.out.println("fname "+request.getParameter("fname"));
		
		admin.setFirstName(request.getParameter("fname"));
		admin.setLastName(request.getParameter("lname"));
		admin.setMobileNumber(request.getParameter("MNum"));
		admin.setEmail(request.getParameter("email"));
		admin.setPassword(request.getParameter("pass"));
		admin.setConfirmPassword(request.getParameter("pass2"));
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		
		
		if (con == null) {
			out.write("Connection Not Established");
		} else {
			try {
				

				
				Statement st2 = con.createStatement();
				String sql2 = "select * from admin where email = '"
						+ admin.getEmail() + "'"; 
				ResultSet rs2 = st2.executeQuery(sql2);
				
			
				 if (rs2.next()) {
					Object message = "Email exist";
					request.setAttribute("emailExist", message);
					request.getRequestDispatcher("/adminReg.jsp").forward(
							request, response);
				}
				
				else if (!admin.getPassword().equals(admin.getConfirmPassword())) {
					Object message = "Password not matching";
					request.setAttribute("passwordMatchingErr", message);
					request.getRequestDispatcher("/adminReg.jsp").forward(
							request, response);
				}

				else if (!admin.getEmail().matches(
						"^[A-Z0-9a-z._%+-]+@[A-Z0-9a-z]+\\.[A-Za-z]{2,6}$")) {
					Object message = "Use Standered email";
					request.setAttribute("emailErr", message);
					request.getRequestDispatcher("/adminReg.jsp").forward(
							request, response);
				}

				else {

					String sql3 = "insert into admin (fname,lname,MNum,email,pass,pass2,gender)"
							+ "values(?,?,?,?,?,?,?)";

					PreparedStatement pre = con.prepareStatement(sql3);

					
					pre.setString(1, admin.getFirstName());
					pre.setString(2, admin.getLastName());
					pre.setString(3, admin.getMobileNumber());
					pre.setString(4, admin.getEmail());
					pre.setString(5, admin.getPassword());
					pre.setString(6, admin.getConfirmPassword());
					pre.setString(7, "male");
					
					pre.execute();
					
					HttpSession session = request.getSession();
					
					session.setAttribute("fname", admin.getFirstName());
					session.setAttribute("lname", admin.getLastName());
					session.setAttribute("MNum", admin.getMobileNumber());
					session.setAttribute("email", admin.getEmail());
					session.setAttribute("pass", admin.getPassword());
					session.setAttribute("pass2", admin.getConfirmPassword());
					
					
				
					request.getRequestDispatcher("/adminPro.jsp").forward(request,
							response);

				}
				
			} catch (Exception e) {
				System.out.println("Got an exception");
				System.out.println(e.getMessage());
				System.out.println("ConnectionEstablished"+request.getParameter("fname")+" "+admin.getConfirmPassword());
			}
		}	
		
		
	}

}
