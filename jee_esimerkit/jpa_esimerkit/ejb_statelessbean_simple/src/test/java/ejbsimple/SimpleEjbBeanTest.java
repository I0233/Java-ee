package ejbsimple;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/* 
 * EJB papuja voi testata käyttäen embedded EJBContainer APIa EJB 3.1:ssa.

 INFO - Jndi(name="java:global/ejb_statelessbean_simple/MySimpleBean!ejbsimple.MySimpleBean")
 INFO - Jndi(name="java:global/ejb_statelessbean_simple/MySimpleBean")
 INFO - existing thread singleton service in SystemInstance() org.apache.openejb.cdi.ThreadSingletonServiceImpl@49e4cb85
 INFO - OpenWebBeans Container is starting...
 INFO - Adding OpenWebBeansPlugin : [CdiPlugin]
 INFO - Adding OpenWebBeansPlugin : [OpenWebBeansJsfPlugin]
 INFO - All injection points were validated successfully.
 INFO - OpenWebBeans Container has started, it took [108] ms.
 INFO - Created Ejb(deployment-id=MySimpleBean, ejb-name=MySimpleBean, container=Default Stateless Container)
 INFO - Started Ejb(deployment-id=MySimpleBean, ejb-name=MySimpleBean, container=Default Stateless Container)
 INFO - Deployed Application(path=/home/juha/jee/was-esimerkit/ejb_statelessbean_simple)

 */

public class SimpleEjbBeanTest {

	private static EJBContainer ejbContainer;

	private MySimpleBean simplebean;

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

		// JNDI nimiviittaus: ejb_statelessbean_simple on paikka, jossa
		// MySimpleBean sijaitsee
		Object object = ejbContainer.getContext().lookup(
				"java:global/ejb_statelessbean_simple/MySimpleBean");

		// Object object =
		// ejbContainer.getContext().lookup("java:global/ejb_statelessbean_simple/MySimpleBean!ejbsimple.MySimpleBean");

		assertTrue(object instanceof MySimpleBean);

		simplebean = (MySimpleBean) object;
	}

	/**
	 * testataan helloWorld() -metodia ja sen palauttamaan arvoa.
	 */
	@Test
	public void testDoHelloWorld() throws NamingException {
		System.out.println("doHelloWorld test");

		String result = simplebean.helloWorld();
		assertEquals("Hello World", result);
	}

	/**
	 * Test of reverse method.
	 */
	@Test
	public void testReverse() throws NamingException {
		System.out.println("reverse test");
		String str = "Saippuakauppias";
		String expResult = "saippuakauppiaS";

		String result = simplebean.reverse(str);
		System.out.println("KÄÄNNETTY TULOS: " + result);
		assertEquals(expResult, result);

	}

	@Test
	public void testCount() throws NamingException {
		System.out.println("count sum");

		int a = 3, b = 2;
		int expResult = 5;
		int result = simplebean.countSum(a, b);
		System.out.println("Summa: " + result);
		assertEquals(expResult, result);
	}

	@Test
	public void testArrayCount() throws NamingException {
		System.out.println("count sum");

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int expResult = 55;
		int result = simplebean.countSum(a);
		System.out.println("Summa taulukolle: " + result);
		assertEquals(expResult, result);
	}

}
