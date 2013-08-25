package regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolveRegexes {
	public static void main(String[] args){
	
		String blurb = "This is a blurb of text to test regex pattern test. It has a phone " +
				"number like (404) 555-4466 but it could also look like 404 555 4466 and what about 404.555.4466 ." +
				"We could also have a date 1/1/90 or 01/01/1990.";
		
		System.out.println(FindPhoneNumbers(blurb).toString());
		System.out.println(FindDate(blurb).toString());
		
	}

	private static ArrayList<String> FindDate(String blurb) {
		// Find all dates in input string and return matches
		//String pattern = "\\d{1,2}(\\/|-| )\\d{1,2}?(\\/|-| )\\d{2,4}";
		
		//Yeah, but is the date valid?
		String pattern = "([0][1-9]|[1][1-2]|[0-9])\\/([0-2][1-9]|[3][0-1]|[1-9])\\/([1][0-9][0-9][0-9]|[0-9][0-9])";
		
		//TODO: How would I handle name of the month
		
		return findPattern(blurb, pattern);
	}

	private static ArrayList<String> FindPhoneNumbers(String blurb) {
		// Find all US phone numbers in input string and return all matches 
		
		//OK pattern
		//String pattern = "\\d{3}([,\\s])?\\d\\d\\d([,\\s])?\\d\\d\\d\\d";
		//Better pattern
		String pattern = "\\(?\\d{3}\\)?(\\s|-|\\.)?\\d{3}(\\s|-|\\.)?\\d{4}";
		return findPattern(blurb, pattern);
	}

	private static ArrayList<String> findPattern(String blurb, String pattern) {
		// worker
		ArrayList<String> matches = new ArrayList<String>();
		Matcher m = Pattern.compile(pattern).matcher(blurb);
		while(m.find())
		{
			matches.add(m.group());
		}
		return matches;
	}

}
