/**
 * LeetCode Problem : Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 * Optimized solution using two-pointer technique.
 */

package main.java.arrays;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "race a car";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome(s));
    }

    /**
     * Brute Force Approach :
     * First we filter out only alphanumeric characters.
     * Then we use two pointers to check, valid palindrome
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */

    public boolean isPalindromeBruteForce(String s) {
        StringBuilder filtered = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }
        int start = 0;
        int end = filtered.length() - 1;

        while (start < end) {
            if (filtered.charAt(start) != filtered.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    /**
     * Optimized Solution (Two Pointers):
     * Initialize two pointers from both ends of the string.
     * Skip non-alphanumeric characters.
     * Compare lowercase characters from both ends.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }


    /**
     * If you feel there is a slight performance overhead using Character.isLetterOrDigit()
     * use the below method.
     */
    private boolean isAlphaNumeric(char c){
        return (c >= 48 && c <= 57) || (c > 96 && c < 123) ;
    }
}
