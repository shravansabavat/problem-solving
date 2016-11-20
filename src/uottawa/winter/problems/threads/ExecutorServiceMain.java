package uottawa.winter.problems.threads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecutorServiceMain {
	
	public static void main(String[] args){
		String str = "This is 1 test 123-456-7890 This is 1 test 623-456-65790 ";
		Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
		    System.out.println(matcher.group(0));
		}
	}

}
