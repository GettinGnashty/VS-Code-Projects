package leetcode_stuff;

import java.util.ArrayDeque;
import java.util.Deque;

/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false */
public class leetcode8 {

    public static void main(String[] args) {
        String s = "([)]";
        isValid(s);

    }

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            System.out.println(false);
            return false;
        } else {
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid;
            String parenth = "()";
            String square = "[]";
            String curly = "{}";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == parenth) {
                            
                        
                    
                }
            }
            System.out.println(isValid);
            return isValid;

        }
    }
}
