// Wes Breisch
// CSC375 Practice #8

package csc375.Practice_08.problem03test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

import csc375.Practice_08.problem03.PrimeTester;

public class PrimeTesterTest {

	@Test
	public void test1() {
		PrimeTester pt = new PrimeTester();
		Function<Integer, Boolean> function = pt.getFunction();
		ArrayList<Integer> input = new ArrayList<Integer>();
		
		input.add(71); // is prime
		input.add(89234); // is not prime
		input.add(3972119); // is prime
		input.add(400); // is not prime

		Collection<Boolean> transformed = Collections2.transform(input, function);
		Iterator<Boolean> transformedIterator = transformed.iterator(); // used to iterate over the Collection<Boolean> of transformed variable
		
		boolean[] expectedResults = {true, false, true, false};
		for (int i=0 ; i<transformed.size() ; i++) {
			assertEquals(transformedIterator.next(), expectedResults[i]);
		}
	}

}
