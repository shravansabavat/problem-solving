package uottawa.coding;

public class NumberOfWords {

    
    public static void main(String[] args) {
        String test = "this is sample sentence to test my code";
        boolean spaceStarted = true;
        boolean spaceEnded = false;
        int count = test.length() > 0 ? 1 : 0;
        for (int index = 0; index < test.length(); index++) {
            if (test.charAt(index) == ' ' && spaceStarted) {
                spaceEnded = true;
            }
            
            if (spaceStarted && spaceEnded) {
                count += 1;
                spaceEnded = false;
            }
        }
        
        System.out.println(count);
    }
}
