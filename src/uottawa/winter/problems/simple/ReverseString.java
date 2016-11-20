package uottawa.winter.problems.simple;

public class ReverseString {
	
	public static char[] reverseString(String original){
		char[] charrString = original.toCharArray();
		int i = 0;
		int j = charrString.length - 1;
		for(char ch : charrString){
			if(i > j/2){
				break;
			}
			char temp = ch;
			charrString[i] = charrString[j];
			charrString[j] = temp;
			i++;
			j--;
		}
		return charrString;
	}
	
	public static String recurseReverse(String original){
		if(null == original || original.length() == 1){
			return original;
		}
		
		return recurseReverse(original.substring(1)) + original.substring(0,1);
	}
	
	public static void main(String[] args){
		
		char[] reverseString = reverseString("shravan");
		System.out.println(reverseString);
		
		String recurseString = recurseReverse("kumar");
		System.out.println(recurseString);
		
	}

}
