package uottawa.winter.problems.binarytree;

public class FirstRepeatedCharacter {
	
	public static void main(String[] args) {
		String str = "abcdefghijklmnopqrstuvwxyz";
		str = str.toLowerCase();

		String repeatedString = firstNonRepeatedCharacter(str, 0);
		System.out.println(null == repeatedString? "none": repeatedString);
	}
	
	public static String firstNonRepeatedCharacter(String fullString, int characterIndex) {
		if (fullString == null || characterIndex < 0 || characterIndex > fullString.length() - 1) {
			return null;
		}
		
		String subStringToCheck = fullString.substring(0, characterIndex) + fullString.substring(characterIndex + 1, fullString.length());
		
		if (subStringToCheck.contains(fullString.charAt(characterIndex)+"")) {
			return fullString.charAt(characterIndex)+"";
		}
		
		return firstNonRepeatedCharacter(fullString, ++characterIndex);
	}

}
