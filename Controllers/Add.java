

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = null;
		String description = null;
		int quantity = 0;
		double price = 0;
		
		boolean ok = true;
		
		try{
		name = request.getParameter("name");
		description = request.getParameter("description");
		quantity = Integer.parseInt(request.getParameter("quantity"));
		price = Double.parseDouble(request.getParameter("price"));
		}catch(NumberFormatException e){
			ok=false;
		}
		
		if(ok){
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu27";
            String username = "cs3220stu27";
            String password = "t1##a*!#";

            String sql = "insert inventory (name, description, quantity, price) values (?,?,?,?)";

            c = DriverManager.getConnection( url, username, password );
            
            PreparedStatement pstmt = c.prepareStatement( sql );
            
            pstmt.setString( 1, name );
            pstmt.setString(2, description );
            pstmt.setInt(3, quantity );
            pstmt.setDouble(4, price );
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
		}else{
			request.getSession().setAttribute("addError", "Make sure all fields have valid entries.");
			request.getRequestDispatcher( "/WEB-INF/Add.jsp" ).forward(request, response );
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<InventoryEntry> cart = (List<InventoryEntry>) (request.getSession().getAttribute("cart")==null?new ArrayList<>():request.getSession().getAttribute("cart"));
		request.getSession().setAttribute("cartError", null);
		int cartAmount = (int) (request.getSession().getAttribute("cartAmount")==null?0:request.getSession().getAttribute("cartAmount"));
		
		String id = request.getParameter("id");
		int quantity=0;
		int max = Integer.parseInt(request.getParameter("max"));
		boolean ok = true;
		
		try{
			quantity = Integer.parseInt(request.getParameter("quantity"));
		}catch(NumberFormatException e){
			ok=false;
		}
		if(quantity>max){
			ok=false;
		}
		
		if(ok){
		request.getSession().setAttribute("quantityError", null);
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu27";
            String username = "cs3220stu27";
            String password = "t1##a*!#";
            
            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
           
            ResultSet rs = stmt.executeQuery( "select * from inventory where id="+id+"" );

            while( rs.next() )
            {
                InventoryEntry entry = new InventoryEntry( rs.getString( "name" ), quantity, rs.getDouble("price"),rs.getInt("id"));
                int count = 0;
                for(InventoryEntry x: cart){
                	if(x.id==entry.id){
                		count++;
                	}
                }
                if(count==0){
                	cart.add(entry);
                	cartAmount=cartAmount+quantity;
                }else{
                	request.getSession().setAttribute("cartError", "The item you are trying to add is already in your cart.");
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
		}else{
			request.getSession().setAttribute("quantityError", "Invalid amount for quantity.");
		}
		request.getSession().setAttribute("cartAmount", cartAmount);
        request.getSession().setAttribute("cart", cart);
        response.sendRedirect("Store");
	}

}
