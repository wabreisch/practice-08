package csc375.Practice_08.problem02test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import csc375.Practice_08.problem02.StringProcessor;

public class StringProcessorTest {
	
	@Test
	public void test1() {
		assertEquals("Test 1", new StringProcessor("10.131.52.34").ipAddressToIterable());
	}

	@Test
	public void test2() {
		assertEquals("Test 2", new StringProcessor("12345678ABCD").fourCharSplitter());
	}
	
	@Test
	public void test3() {
		assertEquals("Test 3", new StringProcessor("wabreisch@quinnipiac.edu").validateEmail(), true);
	}

}