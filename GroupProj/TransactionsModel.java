package GroupProj;

public class TransactionsModel {
	String username;
	String name;
	int quantity;
	double price;
	
	public TransactionsModel(String name, int quantity, double price, String username) {
		super();
		this.username = username;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
