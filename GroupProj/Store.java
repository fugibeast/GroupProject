package GroupProj;

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

import GroupProj.InventoryEntry;

@WebServlet("/GroupProj/Store")
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
		request.getSession().setAttribute("takenError", null);
		request.getSession().setAttribute("error", null);
		request.getSession().setAttribute("usernameError", null);
		request.getSession().setAttribute("passwordError", null);
		request.getSession().setAttribute("count", "first");
		
		List<InventoryEntry> inventory = new ArrayList<>();
		String query = request.getParameter("query")==null?"":request.getParameter("query");
		
		if(request.getSession().getAttribute("user")==null){
			response.sendRedirect("Login");
		}else{
		
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu";
            String username = "";
            String password = "";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
           
            ResultSet rs = stmt.executeQuery( "select * from inventory where quantity>0" );
            
            while( rs.next() )
            {
                InventoryEntry entry = new InventoryEntry( rs.getString( "name" ),rs.getString( "description" ), rs.getInt("quantity"), rs.getDouble("price"),rs.getInt("id"));
                if(query == null || entry.getName().toLowerCase().contains(query.trim())||entry.getDescription().toLowerCase().contains(query.trim())){
                inventory.add( entry );
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
        request.setAttribute("inventory", inventory);
        request.getRequestDispatcher( "/WEB-INF/Store.jsp" ).forward(request, response );
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("Login");
	}

}
