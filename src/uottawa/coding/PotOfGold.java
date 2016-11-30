package uottawa.coding;

public class PotOfGold {
    
    public static int[] coins = {0, 2, 5, 2, 10, 20, 30, 3, 1, 4, 6, 0};
    
    public static int max_coin( int[] coins, int start, int end ) {
        if (start > end) {
            return 0;
        }
        
        int a = coins[start] + Math.min(max_coin( coins, start+2,end ), max_coin( coins, start+1,end-1 ));
        int b = coins[end] + Math.min(max_coin( coins, start+1,end-1 ), max_coin( coins, start,end-2 ));
        
        return Math.max(a,b);
    }
    
    public static void main(String[] args) {
        System.out.println(max_coin(coins, 0, coins.length - 1));
    }

}
