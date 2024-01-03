package practiceproject3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PracticeProject3Servlet
 */
@WebServlet("/PracticeProject3Servlet")
public class PracticeProject3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PracticeProject3Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "chandu");
			PreparedStatement ps = con.prepareStatement("select * from product where product_id = ?");
			ps.setString(1, request.getParameter("productid"));
			ResultSet rs = ps.executeQuery();
			writer.println("<html><body bgcolor='azure' style='text-align:center; margin-top:100px'>");
			if(rs.next()) {
			
			writer.println("<h1>PRODUCT DETAILS</h1> "
					+ "<table border='1px' align='center' cellpadding='10px' cellspacing='0' >"
					+ "<tr bgcolor='azure'>	" + "<th>PRODUCT_ID</th>" + "<th>PRODUCT_NAME</th>" + "<th>QTY</th>"+"</tr>");
				writer.println("<tr bgcolor='azure'>");
				writer.print("<td>" + rs.getString("product_id") + "</td>");
				writer.print("<td>" + rs.getString("product_name") + "</td>");
				writer.print("<td>" + rs.getString("QTY") + "</td>");
				writer.println("</tr>");
				

			}
			else{
				writer.println("<h1>Product Id entered was Invalid...</h1>");
			}
			writer.println("</body></html>");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
