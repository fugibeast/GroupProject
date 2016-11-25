package GroupProj;

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

@WebServlet("/GroupProj/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<InventoryEntry> cart = (List<InventoryEntry>) (request.getSession().getAttribute("cart")==null?new ArrayList<>():request.getSession().getAttribute("cart"));
		
		List<InventoryEntry> toRemove = new ArrayList<>();
		for(InventoryEntry x: cart){
			if((x.id)==id){
				toRemove.add(x);
			}
		}
		
		cart.removeAll(toRemove);
		request.getSession().setAttribute("cart", cart);
		response.sendRedirect("Store");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<InventoryEntry> cart = (List<InventoryEntry>) request.getSession().getAttribute("cart");
		List<InventoryEntry> inventory = new ArrayList<>();
		String user = (String) (request.getSession().getAttribute("user")==null?"quest":request.getSession().getAttribute("user"));
		
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu27";
            String username = "cs3220stu27";
            String password = "t1##a*!#";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
           
            ResultSet rs = stmt.executeQuery( "select * from inventory" );
            
            while( rs.next() )
            {
                InventoryEntry entry = new InventoryEntry( rs.getString( "name" ),rs.getString( "description" ), rs.getInt("quantity"), rs.getDouble("price"),rs.getInt("id"));
                inventory.add( entry );
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
		
		if(cart!=null && inventory!=null){
	        try
	        {
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu27";
	            String username = "cs3220stu27";
	            String password = "t1##a*!#";

	            c = DriverManager.getConnection( url, username, password );
	            
	            for(InventoryEntry x : cart){
	            	String sql = "update inventory set quantity=? where id=?";
	            	PreparedStatement pstmt = c.prepareStatement( sql );
	            	
	            	int quantity=0;
	            	int id=0;
	            	
	            	for(InventoryEntry y: inventory){
	            		if(x.id==y.id){
	            			quantity = y.quantity-x.quantity;
	            			id=y.id;
	            		}
	            	}
	            	System.out.print(quantity+" "+id);
	            	pstmt.setInt(1, quantity );
		            pstmt.setInt(2, id);
		            pstmt.executeUpdate();
		            
		            sql = "insert purchases (name, quantity, price, username) values (?,?,?,?)";
		            pstmt = c.prepareStatement( sql );
		            
		            pstmt.setString( 1, x.name );
		            pstmt.setInt(2, x.quantity );
		            pstmt.setDouble(3, x.price );
		            pstmt.setString(4, user );
		            pstmt.executeUpdate();
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
			request.getSession().setAttribute("cart", null);
		}else{
			request.getSession().setAttribute("cartError", "Your cart is empty.");
		}
		response.sendRedirect("Store");
	}

}
