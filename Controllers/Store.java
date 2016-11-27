import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Store")
public class Store extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		List<InventoryEntry> storeInventory = new ArrayList<>();
		String query = request.getParameter("query")==null?"":request.getParameter("query");
		int cartAmount = (int) (request.getSession().getAttribute("cartAmount")==null?0:request.getSession().getAttribute("cartAmount"));
		
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu27";
            String username = "cs3220stu27";
            String password = "t1##a*!#";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
           
            ResultSet rs = stmt.executeQuery( "select * from inventory where quantity>0" );
            
            while( rs.next() )
            {
                InventoryEntry entry = new InventoryEntry( rs.getString( "name" ), rs.getInt("quantity"), rs.getDouble("price"),rs.getInt("id"));
                if(query == null || entry.getName().toLowerCase().contains(query.trim())){
                	storeInventory.add( entry );
            	}
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
        request.getSession().setAttribute("cartAmount", cartAmount);
        request.setAttribute("storeInventory", storeInventory);
        request.getRequestDispatcher( "/WEB-INF/Store.jsp" ).forward(request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}