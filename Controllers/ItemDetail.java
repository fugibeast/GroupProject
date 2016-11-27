

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ItemDetail")
public class ItemDetail extends HttpServlet {
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
        request.getSession().setAttribute("item", item);
        request.getRequestDispatcher( "/WEB-INF/ItemDetail.jsp" ).forward(request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
