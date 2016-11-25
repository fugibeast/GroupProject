package GroupProj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GroupProj/Signup")
public class Signup extends HttpServlet {
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
		request.getRequestDispatcher( "/WEB-INF/Signup.jsp" ).forward(request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username1 = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		request.getSession().setAttribute("usernameError", null);
		request.getSession().setAttribute("passwordError", null);
		boolean ok = false;
		
		if(username1.trim().length()!=0 && password1.trim().length()!=0 && password2.trim().length()!=0 && password1.equals(password2)){
			ok=true;
		}else{
			if(username1.trim().length()==0){
				request.getSession().setAttribute("usernameError", "Make sure you enter a valid username.");
			}
			if(password1.trim().length()==0 && password2.trim().length()==0){
				request.getSession().setAttribute("passwordError", "You must enter a password");
			}else if(password1!=password2){
				request.getSession().setAttribute("passwordError", "Both passwords must match.");
			}
		}
		
		if(ok){
			Connection c = null;
	        try
	        {
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu27";
	            String username = "cs3220stu27";
	            String password = "t1##a*!#";

	            c = DriverManager.getConnection( url, username, password );
	            
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( "select user_name from users" );
	            
	            while( rs.next() )
	            {
	            	if(rs.getString("user_name").equals(username1)){
	            		ok=false;
	            	}
	            }
	            if(ok){
		            String sql = "insert users (user_name, password) values (?,?)";
		            PreparedStatement pstmt = c.prepareStatement( sql );
		            
		            pstmt.setString( 1, username1 );
		            pstmt.setString(2, password1);
		            pstmt.executeUpdate();
		            request.getSession().setAttribute("takenError", null);
	            }else{
	            	request.getSession().setAttribute("takenError", "That username is already taken");
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
	        request.getSession().setAttribute("loginError", null);
	        response.sendRedirect("Login");
        }else{
        	request.getRequestDispatcher( "/WEB-INF/Signup.jsp" ).forward(request, response );
        }
	}

}
