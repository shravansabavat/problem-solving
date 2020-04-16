package leetcode.binarysearch.template1;

public class SquareRoot {

    public static int mySqrt(int x) {
        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(1000));
    }
}
