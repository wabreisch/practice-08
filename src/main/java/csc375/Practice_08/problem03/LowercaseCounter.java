// Wes Breisch
// CSC375 Practice #8

package csc375.Practice_08.problem03;

import com.google.common.base.Function;

public class LowercaseCounter {
	
	private Function<String, Integer> function = new Function<String, Integer>() {
		public Integer apply(String input) {
			// The number of lowercase characters is equal to the length of the original string minus 
			// the original string with the lowercase characters removed
			return ( input.length()-input.replaceAll("[a-z]", "").length() );
		}
	};
	
	public Function<String, Integer> getFunction() {
		return this.function;
	}

}