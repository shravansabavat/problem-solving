package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SwapAdjacentInLRString {
    public static boolean canTransform1(String start, String end) {
        String s1 = "XL";
        String s2 = "LX";
        String s3 = "RX";
        String s4 = "XR";

        Map<String, String> moves = new HashMap<>();
        moves.put(s1, s2);
        moves.put(s2, s1);
        moves.put(s3, s4);
        moves.put(s4, s3);

        if (start == null || end == null) {
            return false;
        }

        if (start.length() != end.length() || start.length() == 1) {
            return false;
        }

        if (start.length() == 2) {
            return moves.get(start)!= null && moves.get(end)!= null&& (moves.get(start).equals(end) || moves.get(end).equals(start));
        }

        for (int i = 0; i < start.length() - 1;) {
            String checkStart = start.substring(i, i + 2);
            String checkEnd = end.substring(i, i + 2);

            if (checkStart.equals(checkEnd)) {
                i = i + 2;
                continue;
            } else {
                String moveStr = moves.get(checkStart);
                if (moveStr != null && moveStr.equals(checkEnd)) {
                    if (i > 0) {
                        start = start.substring(0, i) + moveStr + start.substring(i + 2);
                    } else {
                        start = moveStr + start.substring(i + 2);
                    }
                    i = i + 2;
                } else {
                    i = i + 1;
                }
            }
        }
        return start.equals(end);
    }

    public static boolean canTransform(String start, String end) {
        int r = 0, l = 0;
        for (int i = 0; i< start.length(); i++){
            if (start.charAt(i) == 'R'){ r++; l = 0;}
            if (end.charAt(i) == 'R') { r--; l = 0;}
            if (end.charAt(i) == 'L') { l++; r = 0;}
            if (start.charAt(i) == 'L') { l--; r = 0;}
            if (l < 0 || r < 0) return false;
        }

        if (l != 0 || r != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
        System.out.println(canTransform("LLR", "RRL"));
        System.out.println(canTransform("RL", "LR"));
        System.out.println(canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
    }
}
