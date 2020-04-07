package leetcode.thirtyday;

import java.util.HashSet;

public class Day2HappyNumber {
    public static boolean happyNumber(int n) {
        if (n == 1) {
            return true;
        }
        HashSet<Integer> seenNumbers = new HashSet<>();
        while (seenNumbers.add(n)) {
            int sum = 0;
            while (n > 0) {
                int newNumber = n % 10;
                sum += Math.pow(newNumber, 2);
                n = n / 10;
            }

            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(happyNumber(19));
    }
}
