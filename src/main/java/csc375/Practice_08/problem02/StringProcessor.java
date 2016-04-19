package csc375.Practice_08.problem02;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

public class StringProcessor {
	
	private String input;
	
	public StringProcessor(String input) {
		this.input = input;
	}
	
	public Iterable<String> ipAddressToIterable() {
		return Splitter.on('.').split(this.input);
	}
	
	public boolean validateEmail() {
		String emailUsername = this.input.split("@")[0];
		CharMatcher matcher = CharMatcher.inRange('a', 'z')
				.or(CharMatcher.inRange('A', 'Z')
				.or(CharMatcher.is('_')));
		
		return matcher.matchesAllOf(emailUsername);
	}
	
	public Iterable<String> fourCharSplitter() {
		return Splitter.fixedLength(4).split(this.input);
	}

}