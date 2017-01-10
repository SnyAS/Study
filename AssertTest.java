import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class AssertTest {
	//experimental value vs actual value
	@Test
	public void test() {
		int three = Math.add(4, 5);
				//expected, actual, delta
		assertEquals(9, three , 0);
	}
	
	//nullpointer
	@Test
	public void test1(){
		ArrayList b = Math.initializer(0);
		assertNull(b);
	}
	
	//timeout infinite loop
	@Test (timeout = 1000)//1second
	public void test2(){
		int three = Math.loop(1);
		assertEquals(1, three, 0);		
	}
}