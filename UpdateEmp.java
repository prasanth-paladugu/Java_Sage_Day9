

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
 * Servlet implementation class UpdateEmp
 */
public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
		{			  
           Connection con = DataBaseConnection.initializeDatabase(); 
  
           PreparedStatement st = con.prepareStatement("UPDATE employee234 SET ename=?, eemid=?, emob=? WHERE eid=?"); 
  
           st.setInt(4, Integer.valueOf(request.getParameter("eid"))); 
           st.setString(1, request.getParameter("ename"));
           st.setString(2, request.getParameter("eemid"));
           st.setString(3, request.getParameter("emob"));
           st.executeUpdate(); 
           st.close(); 
           con.close(); 
  
           PrintWriter out = response.getWriter(); 
            out.println("<html><body><b>Employee Details Successfully Updated"
                    + "</b></body></html>"); 
        } 
        catch (Exception e) 
		{ 
            e.printStackTrace(); 
        } 

	}

}
