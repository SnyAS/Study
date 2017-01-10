package TstingJunit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/*public class TestJunitTest {

	@Test
	public void test() {
		// name of class
		TestingJunit test = new TestingJunit();
		String result = test.concatinate("one", "two");
		assertEquals("onetwo", result);
	}

	@Test
	public void testMult() {
		// name of class
		TestingJunit test = new TestingJunit();
		// method name
		int result = test.multiply(3, 4);
		assertEquals(12, result);

	}
}
*/
public class TestLocation {

	@Before
	public void initializeLocations() {
		//Location loc = new Location(0, 0);
		Location locationMinusX = new Location(-1l, 1);
		Location locationzeroX = new Location(0l, -1);
		Location locationPlusX = new Location(1l, 0);
	}

	/*@Test
	public void testGetX() {
		assertEquals(1l, locationPlusX.getX(), 0);
		assertNotEquals(1l, locationPlusX.getY(), 0);
		assertEquals(-1l, locationMinusX.getX(), 0);
		assertNotEquals(-1l, locationMinusX.getY(), 0);
		assertEquals(0l, locationzeroX.getX(), 0);
		assertNotEquals(0l, locationzeroX.getY(), 0);
	}
	*/
	@Test
	public void testGetX() {
		Location location = new Location(1l, 2l);
		assertEquals(1l, location.getX(), 0);
		assertNotEquals(1l, location.getY(), 0);
		location = new Location(-1l, 2l);
		assertEquals(-1l,location.getX(),  0);
		assertNotEquals(-1l, location.getY(), 0);
		location = new Location(0l, 2l);
		assertEquals(0l,location.getX(),  0);
		assertNotEquals(0l, location.getY(), 0);
	}


}
