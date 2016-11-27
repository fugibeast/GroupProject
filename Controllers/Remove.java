

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = -1;
		boolean ok = true;
		
		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch(NumberFormatException e){
			ok = false;
		}
		
		if(ok){
			Connection c = null;
	        try
	        {
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu27";
	            String username = "cs3220stu27";
	            String password = "t1##a*!#";
	
	            String sql = "delete from inventory where id=?";
	
	            c = DriverManager.getConnection( url, username, password );
	            
	            PreparedStatement pstmt = c.prepareStatement( sql );
	
	    		pstmt.setInt( 1,id);
	            pstmt.executeUpdate();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }
	        finally
	        {
	            try
	            {
	                if( c != null ) c.close();
	            }
	            catch( SQLException e )
	            {
	                throw new ServletException( e );
	            }
	        }
	        
	        response.sendRedirect("Inventory");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
