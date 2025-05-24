/**
 * LeetCode Problem :Longest SubString without repeating characters.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Contains both brute force and optimized solution.
 */

package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstring longestSubstring = new LongestSubstring();

        System.out.println(longestSubstring.lengthOfLongestSubstring(s));
    }


    /**
     * Brute Force Approach:
     * Generate all substrings and check if all characters are unique.
     * Use a Set to track duplicates in each substring.
     * Time Complexity: O(n^3)
     * Space Complexity: O(n)
     */

    public int lengthOfLongestSubstringBruteForce(String s) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    break;
                }
                set.add(c);
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }

    /**
     * Optimized Approach (Sliding Window):
     * Use a sliding window and a HashMap to store the last index of each character.
     * If a repeating character is found within the window, move the start of the window.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character,Integer> lastIndex = new HashMap<>();

        int start = 0;

        for(int end = 0; end < s.length(); end++){
            char c = s.charAt(end);

            if(lastIndex.containsKey(c) && lastIndex.get(c) >= start){
                start = lastIndex.get(c) + 1;
            }
            lastIndex.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
