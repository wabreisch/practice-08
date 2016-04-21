// Wes Breisch
// CSC375 Practice #8

package csc375.Practice_08.problem03test;

import csc375.Practice_08.problem03.DateMaker;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

public class DateMakerTest {
	
	@Test
	public void test1() {
		ArrayList<String> input = new ArrayList<String>();

		input.add("01/01/12");
		input.add("04/25/16");
		input.add("04/20/16");

		Function<String, Date> function = new DateMaker().getFunction();
		Collection<Date> transformed = Collections2.transform(input, function);
		Iterator<Date> transformedIterator = transformed.iterator();
		
		Date[] expectedResults = {new Date(112, 0, 01), new Date(116, 3, 25), new Date(116, 3, 20)};

		for (int i=0 ; i<transformed.size() ; i++) {
			assertEquals(transformedIterator.next(), expectedResults[i]);
		}
	}
	
}