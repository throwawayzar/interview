import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class DataStruct {

	public static void main(String [] args)
	{
		//System.out.println(nMostCommon("my name is Azhar", 3));
		ArrayList<String> listofwords = new ArrayList<String>();
		listofwords.add("mary");
		listofwords.add("john");
		listofwords.add("army");
		listofwords.add("ramy");
		listofwords.add("whodat");
		printAnagrams(listofwords, "yamr");
	}
	
	public static void printAnagrams(ArrayList<String> listofwords, String findMe)
	{
		char[] sortedFindMe = findMe.toCharArray();
		Arrays.sort(sortedFindMe);
		findMe = new String(sortedFindMe);
		
		for(String word : listofwords)
		{
			if(word.length() == findMe.length())
			{
				char[] sortedChars = word.toCharArray();
				Arrays.sort(sortedChars);
				String sortedWord = new String(sortedChars);
				
				if(sortedWord.equals(findMe))
					System.out.println(word);
			}
		}
	}
	public static char[] nMostCommon(String str, int n)
	{
		char[] ret = new char[n];
		final Map<Character, Integer> counts = new HashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++)
		{
			if(counts.containsKey(str.charAt(i)))
				counts.put(str.charAt(i), counts.get(str.charAt(i))+1);
			else
				counts.put(str.charAt(i), 1);
		}
		List<Character> popularChars = new ArrayList<Character>(counts.keySet());
		
		Collections.sort(popularChars, new Comparator<Character>(){

			@Override
			public int compare(Character arg0, Character arg1) {
				return counts.get(arg1) - counts.get(arg0);
			}
			
		});
		
		System.out.println(popularChars.toString());
		System.out.println(counts.toString());
	    return ret;
	}
	public static int makeChange(int n, int denom) { int next_denom = 0;
		switch (denom) {
			case 25:
				next_denom = 10;
		        break;
		    case 10:
		    	next_denom = 5;
		        break;
		    case 5:
		    	next_denom = 1;
		        break;
		    case 1:
		    	return 1; 
    	}
		int ways = 0; 
		
		for(int i=0;i*denom<=n;i++){
			ways += makeChange(n - i * denom, next_denom); 
		}
		return ways; 
	}
	
	public static ArrayList<String> getPerms(String s) { 
		ArrayList<String> permutations = new ArrayList<String>(); 
		if (s == null) { // error case
			return null;
		} 
		else if (s.length() == 0) { // base case
			permutations.add(""); 
			return permutations;
		}
		char first = s.charAt(0); // get the first character
		String remainder = s.substring(1); // remove the first character 
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
		for (int j = 0; j <= word.length(); j++) {
		permutations.add(insertCharAt(word, first, j)); }
		}
		return permutations;
		}
	
		public static String insertCharAt(String word, char c, int i) { 
			String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
		}
}
