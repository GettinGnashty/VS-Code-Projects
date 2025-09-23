package leetcode_stuff;

public class leetcode2 {

    public static void main(String[] args) {
        System.out.println(palindrome(-131));
    }

    public static boolean palindrome(int x) {

        String emptyString = "";
        String numberToString = Integer.toString(x);
        for (int i = numberToString.length() - 1; i >= 0; i--) {
            emptyString += numberToString.charAt(i);
        }
        try {
            int emptyStringtoInt = Integer.parseInt(emptyString);
            System.out.println("X = " + x);
            System.out.println("String reversed = " + emptyStringtoInt);
            return emptyStringtoInt == x;
        } catch (NumberFormatException e) {
            return false;

        }
    }
}
