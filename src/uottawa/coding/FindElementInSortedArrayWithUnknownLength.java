package uottawa.coding;

public class FindElementInSortedArrayWithUnknownLength {
    public static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
    public static int num = 13;

    public static void main(String[] args) {
        System.out.println(findIndex());
    }

    public static int findIndex() {
        int index = 0, exp = 0;
        while (true) {
            try {
                if (arr[index] == num) {
                    return index;
                } else if (arr[index] <= num) {
                    index = (int) Math.pow(2, exp);
                    exp++;
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }

        int low = 0;
        int high = index;
        while (low < high) {
            int mid = (low + high) / 2;
            try {
                if (arr[mid] == num) {
                    return mid;
                } else if (arr[mid] < num) {
                    low = mid + 1;
                } else if (arr[mid] > num) {
                    high = mid - 1;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                high = mid - 1;
            }
        }

        return -1;
    }

}
