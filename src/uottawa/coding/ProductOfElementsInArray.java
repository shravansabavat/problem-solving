package uottawa.coding;


public class ProductOfElementsInArray {

    public static int[] arr = {1,2,3,4};
    public static int[] result = new int[arr.length];

    public static void main(String[] args) {
        int lenArr = arr.length;

        //right product
        result[0] = arr[0];
        int r = arr[0];
        for(int i = 1; i < lenArr;i++) {
            result[i] = r * arr[i-1];
           r = result[i];
        }

        //left product
        r = result[arr.length - 1];
        for(int i = arr.length - 2; i > 0;i--) {
            result[i] = r * arr[i+1];
            r = result[i];
        }
        System.out.println(result);
    }

}
