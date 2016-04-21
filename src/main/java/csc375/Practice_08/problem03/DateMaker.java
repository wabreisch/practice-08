// Wes Breisch
// CSC375 Practice #8

package csc375.Practice_08.problem03;

import java.util.Date;

import com.google.common.base.Function;

public class DateMaker {

	private Function<String, Date> function = new Function<String, Date>() {
		@SuppressWarnings("deprecation") // Java complains about the Date constructor used below
		public Date apply(String input) {
			String[] inputArray = input.split("/"); // Split the provided input on slashes
			return new Date(Integer.parseInt(inputArray[2])+100, Integer.parseInt(inputArray[0])-1, Integer.parseInt(inputArray[1]));
		}
	};
	
	public Function<String, Date> getFunction() {
		return this.function;
	}
	
}