package Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.DBConnector;

/**
 * Servlet implementation class AdminViewUser
 */
public class AdminViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("/records.jsp");
		rd.include(request, response);
		
		out.print("<body>");
		out.print("<h1>Display the records</h1>");
		out.print("<table border='1'><tr>"+
				"<th>First Name</th>"+
				"<th>Last Name</th>"+
				"<th>MobileNumber</th>"+
				"<th>Email</th>"+
				"<th>Password</th>"+
				"<th>ConfirmPassword</th>"+
				"</tr>");
		
		
		try{
			DBConnector db = new DBConnector();
			Connection con = db.getConnection();
		
			Statement stmt = con.createStatement();
			String sql = "select * from  register_customer";
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(((ResultSet) rs).next()){
				out.print("<tr><td>");
				out.println(((ResultSet) rs).getString(1));
				out.print("</td>");
				out.print("<td>");
				out.print(((ResultSet) rs).getString(2));
				out.print("</td>");
				out.print("<td>");
				out.print(((ResultSet) rs).getString(3));
				out.print("</td>");
				out.print("<td>");
				out.print(((ResultSet) rs).getString(4));
				out.print("</td>");
				out.print("<td>");
				out.print(((ResultSet) rs).getString(5));
				out.print("</td>");
				out.print("<td>");
				out.print(((ResultSet) rs).getString(6));
				out.print("</td>");
				out.print("<td>");
				out.print("<th><button onclick=\"window.location.href='AdminDeleteUser.jsp'\">Delete User</button></th>");
				out.print("<th><form action><input type='submit' value='disable user'></form></th>");
				
				
			}
		}
		catch(Exception p){
			System.out.println(p);
		}
		out.print("</table>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
