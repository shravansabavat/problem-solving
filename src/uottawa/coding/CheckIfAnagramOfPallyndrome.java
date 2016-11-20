package uottawa.coding;

public class CheckIfAnagramOfPallyndrome {
    
    public static void main(String[] args) {
        String str = "tactcoapapash";
        
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            int x = getCharNumber(ch);
            int existingValue = table[x];
            table[x] = ++existingValue;
        }
        
        boolean foundOddAlready = false;
        boolean pallyndrome = true;
        for (int count : table) {
            if (count%2 == 1) {
                if (foundOddAlready) {
                    pallyndrome = false;
                    System.out.println("not a pallyndrome anagram");
                    break;
                }
                foundOddAlready = true;
            }
        }
        
        if (pallyndrome) {
            System.out.println("pallyndrome anagram");
        }
    }

    private static int getCharNumber(char ch) {
        int aValue = Character.getNumericValue('a');
        int zValue = Character.getNumericValue('z');
        int chValue= Character.getNumericValue(ch);
        
        if (chValue >= aValue && chValue <= zValue) {
            return chValue - aValue;
        }
        
        return  -1;
    }

}
