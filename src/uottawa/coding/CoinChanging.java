package uottawa.coding;


public class CoinChanging {
    public static int minCoins(int coins[], int m, int V) {
        if (V == 0)  {
            return 0;
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            if (coins[i] <= V) {
                int sub_res = minCoins(coins, m, V-coins[i]);
                res = Math.min(res, sub_res + 1);
            }
        }
        return res;
    }

    /**
     * Space efficient DP solution
     */
    public static int numberOfSolutionsOnSpace(int total, int arr[]){

        int temp[] = new int[total+1];

        temp[0] = 1;
        for(int i=0; i < arr.length; i++){
            for(int j=arr[i]; j <= total ; j++){
                temp[j] += temp[j-arr[i]];
            }
        }
        return temp[total];
    }

    // Driver Function to test above function
    public static void main(String args[]) {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 6;
        System.out.println(numberOfSolutionsOnSpace(n, arr));
        System.out.println(minCoins(arr, arr.length, 6));
        

        //int[] denoms = {1, 5, 6, 8};
        //System.out.println(minCoins(denoms, denoms.length, 15));
    
    }
    
}