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

import csc375.Practice_08.problem03.LowercaseCounter;

public class LowercaseCounterTest {

	@Test
	public void test1() {
		LowercaseCounter lcc = new LowercaseCounter();
		Function<String, Integer> function = lcc.getFunction();
		ArrayList<String> input = new ArrayList<String>();
		
		input.add("hello");
		input.add("THE ANSWER IS four");
		input.add("AND THIS ANSWER SHOULD BE ZERO");
		input.add("twelvetwelve");

		Collection<Integer> transformed = Collections2.transform(input, function);
		Iterator<Integer> transformedIterator = transformed.iterator();
		int[] expectedResults = {5, 4, 0, 12};
		
		for (int i=0 ; i<transformed.size() ; i++) {
			assertEquals(transformedIterator.next(), Integer.valueOf(expectedResults[i]));
		}
		
	}

}
