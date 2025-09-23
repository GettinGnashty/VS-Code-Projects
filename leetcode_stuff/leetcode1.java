package leetcode_stuff;

import java.util.HashMap;

public class leetcode1 {

    public static void main(String[] args) {
        System.out.println(romanToInt("XII"));
    }

    public static int romanToInt(String s) {
        int total = 0;
        HashMap<String, Integer> romans = new HashMap<>();
        romans.put("I", 1);
        romans.put("V", 5);
        romans.put("X", 10);
        romans.put("L", 50);
        romans.put("C", 100);
        romans.put("D", 500);
        romans.put("M", 1000);

        for (int i = 0; i < s.length(); i++) {
            try {
                
                int currentIndex = romans.get(String.valueOf(s.charAt(i)));
                int nextIndex = romans.get(String.valueOf(s.charAt(i + 1)));
                if (nextIndex <= s.length()) {
                    if (currentIndex < nextIndex) { //subtracts if the number before is greater than
                        total -= currentIndex;
                    } else {
                        total += currentIndex;
                    }
                } else {
                    total += currentIndex;
                }
            }catch (Exception e) {

            }
        }
        System.out.println(total);
        return total;
    }
}
