
public class TransactionsModel {
	String name;
	int quantity;
	double total;
	int order_number;
	
	public TransactionsModel(String name, int quantity, double total, int order_number) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.total = total;
		this.order_number = order_number;
	}

	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
