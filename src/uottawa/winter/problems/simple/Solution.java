package uottawa.winter.problems.simple;

import java.util.Stack;

//you can also use imports, for example:
//import java.math.*;
public class Solution {

	public int evaluate(String expression) {
		char[] splitValues = expression.toCharArray();

		Stack<Integer> vals = new Stack<Integer>();

		for (int i = 0; i < splitValues.length; i++)
		{
			if (splitValues[i] == ' ')
				continue;
			if (splitValues[i] >= '0' && splitValues[i] <= '9') {
				vals.push(Character.getNumericValue(splitValues[i]));
			}
			else if (splitValues[i] == '+' || splitValues[i] == '-' ||
					splitValues[i] == '*' || splitValues[i] == '/')	{
				vals.push(applyOp(splitValues[i], vals.pop(), vals.pop()));
			}
		}

		return vals.pop();
	}

	public static boolean hasPrecedence(char op1, char op2)
	{
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	public static int applyOp(char op, int b, int a)
	{
		switch (op)
		{
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		}
		return 0;
	}

	public static void main(String args[]){
		Solution sol = new Solution();
		System.out.println(sol.evaluate("13+12*7+*"));
	}
}
