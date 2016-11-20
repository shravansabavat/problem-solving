package uottawa.coding;

public class LongestCommonSequenceInOneString {

    public static void main(String[] args) {
        String str = "thisiswholeshitshitthisiswholeshitshit";

        char[] chars = str.toCharArray();
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        int startIndex = maxStartIndex;
        int endIndex  = maxEndIndex;

        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1, k = i; j < chars.length; j++) {
                if (chars[k] == chars[j]) {
                    startIndex = i;
                    endIndex = k;
                    k++;
                } else {
                    k = i;
                }
            }

            int maxLength = maxEndIndex - maxStartIndex + 1;
            int maxSubLength = endIndex - startIndex + 1;

            if (maxSubLength > maxLength) {
                maxStartIndex = startIndex;
                maxEndIndex = endIndex;
            }
            if (endIndex > i) {
                i = endIndex + 1;
            }
        }

        System.out.println(str.substring(maxStartIndex, maxEndIndex + 1));
    }

}
