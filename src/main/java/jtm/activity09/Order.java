package jtm.activity09;

/*- TODO #1
 * Implement Comparable interface with Order class
 * Hint! Use generic type of comparable items in form: Comparable<Order>
 * 
 * TODO #2 Override/implement necessary methods for Order class:
 * - public Order(String orderer, String itemName, Integer count) — constructor of the Order
 * - public int compareTo(Order order) — comparison implementation according to logic described below
 * - public boolean equals(Object object) — check equality of orders
 * - public int hashCode() — to be able to handle it in some hash... collection 
 * - public String toString() — string in following form: "ItemName: OrdererName: Count"
 * 
 * Hints:
 * 1. When comparing orders, compare their values in following order:
 *    - Item name
 *    - Customer name
 *    - Count of items
 * If item or customer is closer to start of alphabet, it is considered "smaller"
 * 
 * 2. When implementing .equals() method, rely on compareTo() method, as for sane design
 * .equals() == true, if compareTo() == 0 (and vice versa).
 * 
 * 3. Also Ensure that .hashCode() is the same, if .equals() == true for two orders.
 * 
 */

public class Order implements Comparable<Order> {
	String customer; // Name of the customer
	String name; // Name of the requested item
	int count; // Count of the requested items

	// Constructor
	public Order(String customer, String name, Integer count) {
		this.customer = customer;
		this.name = name;
		this.count = count;
	}

	// Comparison implementation according to the specified logic
	@Override
	public int compareTo(Order order) {
		int itemNameComparison = this.name.compareTo(order.name);
		if (itemNameComparison != 0) {
			return itemNameComparison;
		}

		int customerNameComparison = this.customer.compareTo(order.customer);
		if (customerNameComparison != 0) {
			return customerNameComparison;
		}

		return Integer.compare(this.count, order.count);
	}

	// Check equality of orders
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Order)) {
			return false;
		}

		Order otherOrder = (Order) obj;
		return this.compareTo(otherOrder) == 0;
	}

	// Generate hashCode based on the specified logic
	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + count;
		return result;
	}

	// Generate string representation of the order
	@Override
	public String toString() {
		return name + ": " + customer + ": " + count;
	}
}
