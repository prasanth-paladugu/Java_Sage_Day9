import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.DataBaseConnection;
/**
 * Servlet implementation class NewEmp
 */
public class NewEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{			  
           Connection con = DataBaseConnection.initializeDatabase(); 
  
           PreparedStatement st = con.prepareStatement("Insert into employee234 values(?, ?, ?, ?)"); 
  
           st.setInt(1, Integer.valueOf(request.getParameter("eid"))); 
           st.setString(2, request.getParameter("ename"));
           st.setString(3, request.getParameter("eemid"));
           st.setString(4, request.getParameter("emob"));
           st.executeUpdate(); 
           st.close(); 
           con.close(); 
  
           PrintWriter out = response.getWriter(); 
            out.println("<html><body><b>Employee Details Successfully Created"
                    + "</b></body></html>"); 
        } 
        catch (Exception e) 
		{ 
            e.printStackTrace(); 
        } 
	}

}
