package uottawa.codechef.feb;

public class TestInfor {
    
    public static void main(String[] args ) {
        boolean isLeapYear = isLeapYear(2000);
        
        if(isLeapYear) {
        	System.out.println("yes");
        } else {
        	System.out.println("no");
        }
        
    }
    
    private static boolean isLeapYear(int year) {
      return year % 4 == 0 && (year % 100 != 0 && year % 400 != 0);  
    }
}

interface Instrument {
    
}
interface Guitar extends Instrument {
    public void playMe();
}
class Musician {
    public void sing() {
    	System.out.println("I can sing");
    }
}

class Guitarist extends Musician implements Guitar {
    public void playMe() {
    	System.out.println("I can play guitar");
    }
}

class Vocalist extends Musician {
    
}
