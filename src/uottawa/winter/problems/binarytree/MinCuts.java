package uottawa.winter.problems.binarytree;

public class MinCuts {

    public static void main(String[] args) {
        int[] arr = {5, 4, 4, 2, 2, 8, 10};
        cutSticks(arr);
    }

    static int getFirstMin(int[] arr) {
        int min = 0;
        for (int num : arr) {
            if (num > 0) {
                min = num;
                break;
            }
        }
        return min;
    }

    static void cutSticks(int[] array) {
        int remaining = array.length;
        int size = array.length;

        while (remaining > 0)  {
            int min = getFirstMin(array);

            for (int i = 0; i < size; i++) {
                if (array[i] == 0) {
                    continue;
                }

                if (array[i] < min) {
                    min = array[i];
                } 
            }

            int cuts = 0;
            for (int i = 0; i < size; i++) {
                if (array[i] > 0) {
                    array[i] -= min;
                    if (array[i] == 0) {
                        remaining--;
                    }
                    cuts++;
                }
            }

            System.out.println(cuts);
        }
    }

}


