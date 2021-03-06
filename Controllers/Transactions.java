

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Transactions")
public class Transactions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TransactionsModel> transactions = new ArrayList<>();
		String user = (String) request.getSession().getAttribute("user");
		
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu";
            String username = "";
            String password = "";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
           
            ResultSet rs = stmt.executeQuery( "select * from purchases where username='"+user+"'");
            
            while( rs.next() )
            {
            	TransactionsModel entry = new TransactionsModel( rs.getString( "name" ), rs.getInt("quantity"), rs.getDouble("total"),rs.getInt("order_number"));
                transactions.add( entry );
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
        request.getSession().setAttribute("transactions", transactions);
        request.getRequestDispatcher( "/WEB-INF/Transactions.jsp" ).forward(request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
