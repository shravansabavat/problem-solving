package leetcode.topquestions.array;

public class BadVersion {
    public static int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    public static String hasKey(String str) {
        int start = 0, end = str.length() - 1;
        String key = null;
        int endIndex = 0;
        int startIndex = 0;
        while (start < end) {
            key = str.substring(start, end);
            if (containsKey(key)) end = end - (int)Math.pow(2, endIndex++);
            else start = start + (int)Math.pow(2, startIndex++);
        }
        return key;
    }

    public static boolean isBadVersion(int version) {
        if (version == 5) {
            return true;
        }
        return false;
    }

    public static boolean containsKey(String value) {
        if (value.contains("cat")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(9870));
        System.out.println(hasKey("41549622603955309777243716069cat997997007620439937711509062916"));
    }
}
