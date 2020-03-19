package uottawa.coding;

import java.util.Stack;

public class ExpressionEvaluator {

    public static void main(String[] args) {
        String expression = "1+2-4";
        System.out.println(evaluate(expression));
        System.out.println(evaluate("100 * ( 2 + 12 )"));
        System.out.println(evaluate("100 * ( 2 + 12 ) / 14"));
    }

    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ') {
                continue;
            }
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();
                sbuf.append(tokens[i]);
                while (i + 1 < tokens.length && tokens[i+1] >= '0' && tokens[i+1] <= '9') {
                    sbuf.append(tokens[i + 1]);
                    i++;
                }
                values.push(Integer.parseInt(sbuf.toString()));
            } else if (tokens[i] == '(') {
                ops.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (ops.peek() != '(') {
                    values.push(applyOP(values.pop(), values.pop(), ops.pop()));
                }
                ops.pop();
            } else if (tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '+' || tokens[i] == '-') {
                while(!ops.isEmpty() && hasPrecedence(tokens[i], ops.peek())) {
                    values.push(applyOP(values.pop(), values.pop(), tokens[i]));
                }
                ops.push(tokens[i]);
            }
        }

        while(!ops.isEmpty()) {
            values.push(applyOP(values.pop(), values.pop(), ops.pop()));
        }
        return values.pop();
    }

    private static int applyOP(int value1, int value2, char op) {
        if (op == '*') {
            return value2 * value1;
        }
        if (op == '/') {
            return value2 / value1;
        }
        if (op == '+') {
            return value1 + value2;
        }
        if (op == '-') {
            return value2 - value1;
        }
        throw new RuntimeException();
    }

    private static boolean hasPrecedence(char token, char peek) {
        if ((token == '*' || token == '/') && (peek == '+' || peek == '-')) {
            return true;
        } else {
            return false;
        }
    }
}
