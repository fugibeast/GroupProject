

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ShoppingCartModel> shoppingCart = new ArrayList<>();
		List<InventoryEntry> cart = (List<InventoryEntry>) (request.getSession().getAttribute("cart")==null?new ArrayList<>():request.getSession().getAttribute("cart"));
		
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		double overallTotal = 0;

        for(InventoryEntry item : cart){
			ShoppingCartModel entry = new ShoppingCartModel(item.name, item.quantity, item.quantity*item.price, item.id);
	        shoppingCart.add( entry );
	        overallTotal=overallTotal+entry.total;
        }
        
        request.getSession().setAttribute("overallTotal", currencyFormatter.format(overallTotal));
        request.getSession().setAttribute("shoppingCart", shoppingCart);
        request.getRequestDispatcher( "/WEB-INF/ShoppingCart.jsp" ).forward(request, response );
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<InventoryEntry> cart = (List<InventoryEntry>) (request.getSession().getAttribute("cart")==null?new ArrayList<>():request.getSession().getAttribute("cart"));
		List<InventoryEntry> toRemove = new ArrayList<>();
		int id = Integer.parseInt(request.getParameter("id"));
		int cartAmount = (int) request.getSession().getAttribute("cartAmount");
		
		for(InventoryEntry item: cart){
			if(item.id==id){
				toRemove.add(item);
				cartAmount = cartAmount-item.quantity;
			}
		}
		cart.removeAll(toRemove);
		request.getSession().setAttribute("cartAmount", cartAmount);
		request.getSession().setAttribute("cart", cart);
		doGet(request,response);
	}

}
