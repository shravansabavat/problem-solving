package uottawa.coding;

public class StockBuyAndSell {
    
    public static void main(String[] args) {
        int[] arr = {5, 10, 4, 6, 7};
        int profit = 0;
        int cheapest = arr[0];
        
        for (int index = 0; index < arr.length; index++) {
            cheapest = Math.min(cheapest, arr[index]);
            profit = Math.max(profit, (arr[index] - cheapest));
            
        }
        
        System.out.println(profit);
    }
}
