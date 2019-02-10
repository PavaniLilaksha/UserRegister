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
import Register.User;

/**
 * Servlet implementation class getUser
 */
public class getUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getUser() {
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
		
		PrintWriter out = response.getWriter();
		
		User user=new User();
		
		HttpSession session=request.getSession();  
		user.setEmail((String)session.getAttribute("email"));
		
		DBConnector db = new DBConnector();
		Connection conn = db.getConnection();
		
		try{
			
			Statement st = conn.createStatement();
			String sql = "select fname,lname,MNum,Email,Pass,pass2 from register_customer where email = '"+user.getEmail()+"'";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				user.setFirstName(rs.getString(1));
				user.setLastName(rs.getString(2));
				user.setMobileNumber(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setConfirmPassword(rs.getString(6));
			}
			
			request.setAttribute("user", user);
			request.getRequestDispatcher("/getUser.jsp").forward(request,response);
		}
		catch(Exception p){
			System.out.println(p);
		}
	}

}
