package uottawa.coding;

import java.util.Arrays;

public class CountWaysOfNSteps {
    
    public static void main(String[] args) {
        int n = 10;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        int ways = getWays(n, memo);
        System.out.println(ways);
    }

    private static int getWays(int steps, int[] memo) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        } else if (memo[steps] > -1) {
            return memo[steps];
        } else {
            memo[steps] = getWays(steps - 1, memo) + getWays(steps - 2, memo) + getWays(steps - 3, memo);
            return memo[steps];
        }
    }

}
