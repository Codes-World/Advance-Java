package in.codesworld.aman.main;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import in.codesworld.aman.main.Arithmetic;

/**
 * Unit test for Arithmetic App.
 */
public class AppTest extends TestCase
{
	public void testSumWithPositiveNumber() {
		Arithmetic ar = new Arithmetic();
		int actual = ar.add(10, 20);
		int expected = 30;
		
		//checking for testcase
		assertEquals(actual, expected);
	}
	
/*
	public void testSumWithNegativeNumber() {
		Arithmetic ar = new Arithmetic();
		int actual = ar.add(-10, -20);
		int expected = -31;

		//checking for testcase
		assertEquals(actual, expected);
	}

*/	
	public void testSumWithMixedNumber() {
		Arithmetic ar = new Arithmetic();
		int actual = ar.add(-10, 20);
		int expected = 10;

		//checking for testcase
		assertEquals(actual, expected);
	}

	public void testSumWithZero() {
		Arithmetic ar = new Arithmetic();
		int actual = ar.add(0, 0);
		int expected = 0;

		//checking for testcase
		assertEquals(actual, expected);
	}
}
