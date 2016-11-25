package GroupProj;

import java.io.IOException;
import java.net.ResponseCache;
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

@WebServlet("/GroupProj/Login")
public class Login extends HttpServlet {
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
		
		doPost(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username1= request.getParameter("username")==null?"":request.getParameter("username");
		String password1 = request.getParameter("password")==null?"":request.getParameter("password");
	
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu";
            String username = "";
            String password = "";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
           
            ResultSet rs = stmt.executeQuery( "select * from users" );
            
            while( rs.next() )
            {
                if(rs.getString("user_name").equals(username1.trim()) && rs.getString("password").equals(password1.trim())){
                	request.getSession().setAttribute("user", username1);
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
		if(request.getSession().getAttribute("user")==null){
			String count = (String) (request.getSession().getAttribute("count")==null?"first":request.getSession().getAttribute("count"));
			if(count.equals("first")){
				request.getSession().setAttribute("count", "second");
			}else if(count.equals("second")){
				request.getSession().setAttribute("loginError", "Your username and/or password is incorrect!");
			}
		}
		if(request.getSession().getAttribute("user")!=null){
			request.getSession().setAttribute("error", null);
			response.sendRedirect("Store");
		}else
			request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward(request, response );
		
	}

}
