// Wes Breisch
// CSC375 Practice #8

package csc375.Practice_08.problem03;

import com.google.common.base.Function;

public class PrimeTester {
	
	private Function<Integer, Boolean> function = new Function<Integer, Boolean>() {
		public Boolean apply(Integer input) {
			if (input % 2 == 0) { return false; } // if the input is even, we know it's not prime!
			
			for (int i=3 ; i*i <= input ; i+=2) { // only check the odd numbers & we only need to check up to input^2
												  // because input clearly divides input^2
				if (input % i == 0) { return false; }
			}
			
			return true;
		}
	};
	
	public Function<Integer, Boolean> getFunction() {
		return this.function;
	}

}