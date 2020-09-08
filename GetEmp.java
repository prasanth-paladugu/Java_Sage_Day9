import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.DataBaseConnection;

/**
 * Servlet implementation class GetEmp
 */
public class GetEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
		{			  
           Connection con = DataBaseConnection.initializeDatabase(); 
  
           Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM employee234");						
			int count = 0;						
			while (result.next())
			{
				int id = result.getInt("eid");
				String name = result.getString("ename");
				String email = result.getString("eemid");
				float mob = result.getFloat("emob");
				 
				String output = "User #%d: %s - %s - %s - %s";
				PrintWriter out = response.getWriter(); 
	            out.println(String.format(output, ++count, id, name, email, mob));
			}
        } 
        catch (Exception e) 
		{ 
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
