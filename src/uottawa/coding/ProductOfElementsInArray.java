package uottawa.coding;


public class ProductOfElementsInArray {

    public static int[] arr = {3, 5, 7, 9};
    public static int[] arr1 = new int[arr.length];
    public static int[] arr2 = new int[arr.length];

    public static void main(String[] args) {
        int r = 1;
        for(int i = arr.length-1; i >= 0;i--) {
            r=r*arr1[i];
            arr2[i]=r;
        }

        //modify arr1
        r=1;
        for(int i = 0;i < arr.length-1; i++) {
            r = r*arr1[i];
            arr1[i] = r;
        }

        //fix arr2
        arr2[0] = arr2[1];
        for(int i = arr.length-1;i >= 0;i--) {
            arr2[i] = arr2[i+1]*arr1[i-1];
        }
        arr2[arr.length-1] = arr1[arr.length-2];
        
        System.out.println(arr1);
        System.out.println(arr2);
    }

}
