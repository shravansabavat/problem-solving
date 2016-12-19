package uottawa.coding;

public class MultiplicationWithoutOp {

    public static void main(String[] args) {
        int a = 25;
        int b = 7;

        int bigger = a > b ? a : b;
        int smaller = a < b ? a : b;

        int multiply = multiply(bigger, smaller);
        System.out.println(multiply);

        int divide = divide(bigger, smaller);
        System.out.println(divide);
    }

    private static int divide(int bigger, int smaller) {
        if (bigger == smaller) {
            return 1;
        }
        
        if (bigger < smaller) {
            return 0;
        }

        int half = bigger >> 1;
        int halfSub = divide(half, smaller);

        return halfSub + halfSub;
    }

    private static int multiply(int bigger, int smaller) {
        if (smaller == 1) {
            return bigger;
        }

        int half = smaller >> 1;
            int halfSum = multiply(bigger, half);
            int finalRes = -1;

            if (smaller % 2 == 0) {//even
                finalRes = halfSum + halfSum;
            } else {
                finalRes = halfSum + halfSum + bigger;
            }
            return finalRes;
    }



}
