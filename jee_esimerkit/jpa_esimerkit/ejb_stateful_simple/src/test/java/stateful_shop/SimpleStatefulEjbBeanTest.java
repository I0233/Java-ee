package stateful_shop;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/* EJB beans can be tested using the EJBContainer API in EJB 3.1
 included with Tomee OpenEJB implementation.

 Read document of simple stateful test:
 http://tomee.apache.org/examples-trunk/simple-stateful-callbacks/README.html


 */

public class SimpleStatefulEjbBeanTest {

	private static EJBContainer ejbContainer;

	private CartBean cart;

	@BeforeClass
	public static void startContainer() {
		ejbContainer = EJBContainer.createEJBContainer();
	}

	@AfterClass
	public static void stopContainer() {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}

	@Before
	public void findBean() throws NamingException {

		// ejb_statelessbean_template where this Ejb is located. package names
		// are not needed!
		Object object = ejbContainer.getContext().lookup(
				"java:global/ejb_stateful_simple/CartBean");

		assertTrue(object instanceof CartBean);

		cart = (CartBean) object;
	}

	/**
	 * Test of adding items to the cart.
	 */
	@Test
	public void testAdding() throws NamingException {
		System.out.println("Adding items to cart");

		cart.addItem("Pizza");
		cart.addItem("Orange");
		cart.addItem("Milk");
		cart.addItem("Apple");
		cart.addItem("Beer");
		cart.addItem("Banana");
		cart.removeItem("Beer");

		System.out.println("Listing current cart contents");
		ArrayList<String> items = cart.getItems();
		for (Iterator<String> i = items.iterator(); i.hasNext();) {
			System.out.println("  " + i.next());
		}

		assertEquals(5, cart.getSize());
		assertEquals("Apple", items.get(3));

	}

}
