package jtm.activity09;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.mockito.internal.matchers.Or;

import java.util.*;

/*- TODO #2
 * Implement Iterator interface with Orders class
 * Hint! Use generic type argument of iterateable items in form: Iterator<Order>
 * 
 * TODO #3 Override/implement public methods for Orders class:
 * - Orders()                — create new empty Orders
 * - add(Order item)            — add passed order to the Orders
 * - List<Order> getItemsList() — List of all customer orders
 * - Set<Order> getItemsSet()   — calculated Set of Orders from list (look at description below)
 * - sort()                     — sort list of orders according to the sorting rules
 * - boolean hasNext()          — check is there next Order in Orders
 * - Order next()               — get next Order from Orders, throw NoSuchElementException if can't
 * - remove()                   — remove current Order (order got by previous next()) from list, throw IllegalStateException if can't
 * - String toString()          — show list of Orders as a String
 * 
 * Hints:
 * 1. To convert Orders to String, reuse .toString() method of List.toString()
 * 2. Use built in Collections.sort(...) method to sort list of orders
 * 
 * TODO #4
 * When implementing getItemsSet() method, join all requests for the same item from different customers
 * in following way: if there are two requests:
 *  - ItemN: Customer1: 3
 *  - ItemN: Customer2: 1
 *  Set of orders should be:
 *  - ItemN: Customer1,Customer2: 4
 */

public class Orders implements Iterator<Order> {
	/*-
	 * TODO #1
	 * Create data structure to hold:
	 *   1. some kind of collection of Orders (e.g. some List)
	 *   2. index to the current order for iterations through the Orders in Orders
	 *   Hints:
	 *   1. you can use your own implementation or rely on .iterator() of the List
	 *   2. when constructing list of orders, set number of current order to -1
	 *      (which is usual approach when working with iterateable collections).
	 */
	private List<Order> orderList;
	private Iterator iterator;

	// Constructor to create a new empty Orders
	public Orders() {
		orderList = new ArrayList<>();
		iterator = orderList.iterator();
	}

	// Add passed order to the Orders
	public void add(Order item) {
		orderList.add(item);
	}

	// Get List of all customer orders
	public List<Order> getItemsList() {
		return orderList;
	}

	// Calculate Set of Orders from list
	public Set<Order> getItemsSet() {
		Collections.sort(orderList);
		Set<Order> bulkOrdersSet = new TreeSet<>();
		Order prevOrder = new Order(null,"",0);
		Order bulkOrder = null;

		for (Order currentOrder : orderList) {
			if (prevOrder.name.equals(currentOrder.name)) {
				bulkOrder.customer = bulkOrder.customer + "," + currentOrder.customer;
				bulkOrder.count = bulkOrder.count + currentOrder.count;
			} else {
				if (bulkOrder != null) {
					bulkOrdersSet.add(bulkOrder);
				}

				bulkOrder = new Order(currentOrder.customer,currentOrder.name,currentOrder.count);
			}
			prevOrder = currentOrder;
		}
		if (bulkOrder != null) {
			bulkOrdersSet.add(bulkOrder);
		}
		// This has an issue
		return bulkOrdersSet;

	}

	// Sort list of orders according to the sorting rules
	public void sort() {
		Collections.sort(orderList);
	}

	// Check if there is next Order in Orders
	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	// Get next Order from Orders
	@Override
	public Order next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return (Order)iterator.next();
	}

	// Remove current Order from list
	public void remove() {
		if (!iterator.hasNext() || iterator.equals(null)) {
			throw new IllegalStateException();
		}
		orderList.remove((Order)iterator);
		//currentIndex--;
	}

	// Show list of Orders as a String
	@Override
	public String toString() {
		return orderList.toString();
	}
}
