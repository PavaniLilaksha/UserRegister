package Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.DBConnector;

/**
 * Servlet implementation class AdminDeleteAdmin
 */
public class AdminDeleteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter write = response.getWriter();

		HttpSession session = request.getSession();

		Admin admin = Admin.getInstance();

		admin.setEmail(request.getParameter("emailForDelete"));

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		
		if (con == null)
			write.write("Connection Not Established");

		else {
			write.write("Connection Established" + admin.getEmail());

			if (admin.getEmail().equalsIgnoreCase((String) session.getAttribute("email"))) {
				Object message = "Cannot delete YOURSELF";
				request.setAttribute("deleteError", message);
				request.getRequestDispatcher("/AdminDeleteAdmin.jsp").forward(
						request, response);
			}

			else {
				String sql = "delete from admin where email='"
						+ admin.getEmail() + "'";
				try {
					Statement st = con.createStatement();
					st.executeUpdate(sql);

					RequestDispatcher rd = request
							.getRequestDispatcher("/AdminViewAdmin.jsp");
					rd.forward(request, response);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
