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

    public static boolean isBadVersion(int version) {
        if (version == 5) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(firstBadVersion(9870));
    }
}
