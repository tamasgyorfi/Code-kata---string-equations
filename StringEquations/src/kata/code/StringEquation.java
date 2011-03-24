package kata.code;

import java.util.StringTokenizer;

public class StringEquation {

	private final String input;

	public StringEquation(String input) {
		this.input = input;
	}

	public String[] split() {
		String tempInput = input.replaceAll("'", "").replaceAll("&", " ");
		return tempInput.split("==");
	}

	public boolean isWordConsidered(String string) {
		int sum = 0;
		for (int i=0;i<string.length();i++) {
			if (string.charAt(i) == '*' ) {
				sum++;
			}
		}
		return sum%2==0;
	}

	public boolean isEqual() {
		String[] sides = split();
		String leftSide = sides[0];
		String rightSide = sides[1];
	
		
		String allLeft = getSide(leftSide);
	 	String allRight = getSide(rightSide);
		
		
		return isAnagram(allRight, allLeft);
	}

	private String getSide(String side) {
		String allSide = "";
		StringTokenizer t1 = new StringTokenizer(side, " ");
			while (t1.hasMoreTokens()) {
				String currWord = t1.nextToken();
				if (isWordConsidered(currWord)) {
					allSide += currWord;
				}
			}
		return allSide;
	}

	public boolean isAnagram(String allRight, String allLeft) {
		if (allRight.length() == allLeft.length()) {
			for (int i=0;i<allLeft.length();i++) {
				if (!(allLeft.contains(allRight.charAt(i)+""))) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

}
