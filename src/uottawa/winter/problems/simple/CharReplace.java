package uottawa.winter.problems.simple;

public class CharReplace {

	public static String recurseCharReplace(String original,String replaceChar
			,String replaceCharWith){

		if(original.length() > 1){
			recurseCharReplace(original.substring(1),replaceChar,replaceCharWith);
		}else if(original.equals(replaceChar)){
			original.replaceAll(replaceChar, replaceCharWith);
		}

		if(original.substring(0,1).equals(replaceChar)){
			original.replace(original.charAt(0), replaceCharWith.charAt(0));
		}

		return original;
	}

	public static void main(String[] args){

		System.out.println(recurseCharReplace("shravan", "a", "k"));

	}

}
