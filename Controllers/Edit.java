

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ItemDetailModel item = null;
		
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu27";
            String username = "cs3220stu27";
            String password = "t1##a*!#";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
           
            ResultSet rs = stmt.executeQuery( "select * from inventory where id='"+id+"'" );
            
            while( rs.next() )
            {
                ItemDetailModel entry = new ItemDetailModel( rs.getString( "name" ), rs.getString( "description" ), rs.getInt("quantity"), rs.getDouble("price"),rs.getInt("id"));
                item=entry;
            }
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
        request.setAttribute("editItem", item);
        request.getRequestDispatcher( "/WEB-INF/Edit.jsp" ).forward(request, response );
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		double price = 0;
		int quantity = 0;
		String description = request.getParameter("description");
		int id = Integer.parseInt(request.getParameter("id"));
		
		boolean ok = true;
		
		if(name.trim().length()==0||description.trim().length()==0){
			ok=false;
		}
		
		try{
			price = Double.parseDouble(request.getParameter("price"));
			quantity = Integer.parseInt(request.getParameter("quantity"));
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
	            
	            String sql = "update inventory set name=?, price=?, quantity=?, description=? where id=?";;
	            c = DriverManager.getConnection( url, username, password );
	            
	            PreparedStatement pstmt = c.prepareStatement( sql );;
	        
	            pstmt.setString(1, name);
	            pstmt.setDouble(2,price);
	            pstmt.setInt(3, quantity);
	            pstmt.setString(4, description);
	            pstmt.setInt( 5,id);
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
	        request.getSession().setAttribute("editError", null);
	        response.sendRedirect("Inventory");
		}else{
			request.getSession().setAttribute("editError","Make sure all fields have valid entries!");
			doGet(request, response);
		}
	}

}
