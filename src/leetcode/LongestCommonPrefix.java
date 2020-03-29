package leetcode;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String globalCommonPrefix = "";
        for (int i = 0; i < strs.length - 1; i++) {
            if (i > 0 && "".equals(globalCommonPrefix)) {
                break;
            }

            char[] s1 = strs[i].toCharArray();
            char[] s2 = strs[i + 1].toCharArray();
            char[] smaller = s2;
            char[] bigger = s1;
            if (s1.length < s2.length) {
                smaller = s1;
                bigger = s2;
            }

            StringBuffer commonPrefix = new StringBuffer();
            for (int j = 0; j < smaller.length; j++) {
                if (smaller[j] == bigger[j]) {
                    commonPrefix.append(smaller[j]);
                } else {
                    break;
                }
            }

            if (i == 0) {
                globalCommonPrefix = commonPrefix.toString();
                continue;
            }

            if (globalCommonPrefix.indexOf(commonPrefix.toString()) >= 0 ||
                    commonPrefix.indexOf(globalCommonPrefix) >= 0) {
                globalCommonPrefix = globalCommonPrefix.length() > commonPrefix.toString().length() ? commonPrefix.toString() : globalCommonPrefix;
            } else {
                globalCommonPrefix = "";
            }

        }
        return globalCommonPrefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String[] strs2 = {"a"};
        String[] strs3 = {"caa","","a","acb"};

        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(strs2));
        System.out.println(longestCommonPrefix(strs3));
    }
}
