package leetcode.thirtyday;

public class Day5StockBuySell2 {
    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 1) {
            return 0;
        }
        if (prices.length == 2) {
            return Math.max(0, prices[1] - prices[0]);
        }
        int[][] profitTracker = new int[prices.length][prices.length];
        for (int i = 0; i < prices.length; i++) {
            profitTracker[0][i] = prices[i] - prices[0];
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (j == i) {
                    profitTracker[i][j] = 0;
                } else {
                    int currentProfit = prices[j] - prices[i];
                    if (currentProfit <= 0){
                        profitTracker[i][j] = Math.max(profitTracker[i][j-1], Math.max(currentProfit, profitTracker[i-1][j-1]));
                    } else if (currentProfit > 0 && profitTracker[i-1][j-1] > 0) {
                        profitTracker[i][j] = profitTracker[i-1][j-1] + (prices[j] - prices[j - 1]);
                    } else {
                        profitTracker[i][j] = currentProfit;
                    }
                    maxProfit = Math.max(profitTracker[i][j], maxProfit);
                }
            }
        }

        if (maxProfit < 0) {
            maxProfit = 0;
        }
        return maxProfit;
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++)
            profit += Math.max(0, prices[i] - prices[i - 1]);

        return profit;
    }

    public static void main(String[] args) {
        //int[] nums = {7,1,5,3,6,4};
        //int[] nums = {2,1,2,1,0,0,1};
        int[] nums = {1,2,3,4,5};
        System.out.println(maxProfit(nums));
    }
}
