package uottawa.coding;

public class FindNewCharacterInserted {
    public static String str = "shravan";
    public static String newStr = "shravazn";
    
    public static void main(String[] args) {
        int len = Math.max(str.length(), newStr.length()) - 1;
        int indexOfChar = -1;
        for (int index = 0; index < len; index++) {
            if (index <= str.length() - 1) {
                if (newStr.charAt(index) != str.charAt(index)) {
                    indexOfChar = index;
                    break;
                }
            }
        }
        
        if (indexOfChar == -1) {
            indexOfChar = len;
        }
        
        System.out.println(newStr.charAt(indexOfChar));
        System.out.println(newStr.charAt(findNewCharactedIndex()));
    }
    
    public static int findNewCharactedIndex() {
        int len = Math.max(str.length(), newStr.length()) - 1;
        int indexOfChar = -1;
        for (int index = 0; index < len; index++) {
            int val = newStr.charAt(index) ^ str.charAt(index);
            if (val != 0) {
                indexOfChar = index;
                break;
            }
        }
        
        if (indexOfChar == -1) {
            indexOfChar = len;
        }
        
        return indexOfChar;
    }

}
