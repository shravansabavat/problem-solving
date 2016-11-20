package uottawa.coding;

import java.util.ArrayList;

public class MatchingParenthesis {
    
    public static void main(String[] args) {
        ArrayList<String> rsult = generateParenthesis(3);
        System.out.println(rsult);
    }
    
    private static void addparenthesis(ArrayList<String> list, int left, int right, char[] ch, int index) {
        if (left < 0 || right < left)  {
            return;
        }
        
        if (left == 0 && right == 0) {
            list.add(String.copyValueOf(ch));
        } else {
            ch[index] = '(';
            addparenthesis(list, left - 1, right, ch, index + 1);

            ch[index] = ')';
            addparenthesis(list, left, right - 1, ch, index + 1);
        }
    }
    
    private static ArrayList<String> generateParenthesis(int count) {
        char[] chars = new char[count*2];
        ArrayList<String> list = new ArrayList<String>();
        addparenthesis(list, count, count, chars, 0);
        return list;
    }

}
