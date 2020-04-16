package leetcode.thirtyday;

public class Day14PerformStringOperations {

    public static String stringShift(String s, int[][] shift) {
        int shifts = 0;
        for (int[] arr : shift) {
            int move = arr[0];
            int value = arr[1];
            if (move == 1) {
                shifts += value;
            } else {
                shifts -= value;
            }
        }
        shifts = shifts % s.length();
        if (shifts < 0) {
            shifts = s.length() - Math.abs(shifts);
        }

        return shift(s, shifts);
    }

    public static String shift(String s, int shifts) {
        for (int i = 0; i < shifts; i++) {
            s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
        }

        return s;
    }

    public static void main(String[] args) {
        String s = "xqgwkiqpif";
        int[][] shifts = {{1,4},{0,7},{0,8},{0,7},{0,6},{1,3},{0,1},{1,7},{0,5},{0,6}};
        System.out.println(stringShift(s, shifts));
    }
}

