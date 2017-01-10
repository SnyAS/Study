package jtest;

import static org.junit.Assert.*;
import math.BoundVector;

import org.junit.Before;
import org.junit.Test;

public class TestMatrix {
	
	@Before
	public void initialize() {
		matrix2by3 = fillMatrix(2,3);
		matrix3by2 = fillMatrix(3,2);
		matrix3by4 = fillMatrix(3,4);
	}
	

	@Test
	public void testMultiply() {
		Matrix result = matrix2by3.multiply(matrix3by2);
		assertEquals(EXPECTED_VALUE, result.hashCode(), 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMultiplyWrong() {
		Matrix result = matrix3by2.multiply(matrix3by4);
	}



}
