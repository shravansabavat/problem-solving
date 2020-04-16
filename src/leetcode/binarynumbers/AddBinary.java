package leetcode.binarynumbers;

public class AddBinary {
    public static String addBinary(String a, String b) {
        int lenA = a.length(), lenB = b.length();
        int n = lenA > lenB ? lenA : lenB;
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for (int i = 0; i < n; i++) {
            int n1 = 0, n2 = 0;
            if ( i < lenA) n1 = Character.getNumericValue(a.charAt(lenA - i - 1));
            if ( i < lenB) n2 = Character.getNumericValue(b.charAt(lenB - i - 1));
            int sum = n1 + n2 + carry;
            carry = sum >= 2 ? 1 : 0;
            sb.append(sum % 2);
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}
