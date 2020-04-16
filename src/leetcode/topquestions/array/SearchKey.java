package leetcode.topquestions.array;

public class SearchKey {
    public static String hasKey(String str) {
        int start = 0, end = str.length() - 1;
        return str.substring(
                getStartIndex(str, start, end),
                getEndIndex(str, start, end)
        );
    }

    public static int getEndIndex(String str, int start, int end) {
        int index = 0;
        int move = 0;
        int previousValidEnd = 0;
        while (!(previousValidEnd <= end && end == previousValidEnd)) {
            try {
                if (containsKey(str.substring(start, end))) {
                    previousValidEnd = end;
                    move = (int)Math.pow(2, index++);
                    end = end - move;
                } else {
                    move = (move - move/2);
                    end = end + move;
                }
            } catch(Exception exp) {
                move = (move - move/2);
                end = end + move;
            }

        }
        return previousValidEnd;
    }

    public static int getStartIndex(String str, int start, int end) {
        int index = 0;
        int move = 0;
        int previousValidStart = 0;
        while (!(previousValidStart > 0 && start - 1 == previousValidStart)) {
            try {
                if (containsKey(str.substring(start, end))) {
                    previousValidStart = start;
                    move = (int)Math.pow(2, index++);
                    start = start + move;
                } else {
                    move = (move - move/2);
                    start = start - move;
                }
            } catch(Exception exp) {
                move = (move - move/2);
                start = start - move;
            }

        }
        return previousValidStart;
    }

    public static boolean containsKey(String value) {
        if (value.contains("catcat")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasKey("catcat99799700762043993771150906291699799700762043993771150906291699799700762043993771150906291699799700762043993771150906291699799700762043993771150906291641549622603955309777243716069997997007620439937711509062916997997007620439937711509062916997997007620439937711509062916997997007620439937711509062916997997007620439937711509062916"));
    }
}
