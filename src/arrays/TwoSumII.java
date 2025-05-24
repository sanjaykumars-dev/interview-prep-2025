/**
 * LeetCode Problem: Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * This class contains:
 * Brute Force solution – O(n^2)
 * HashMap-based solution for unsorted arrays – O(n) time, O(n) space
 * Optimized Two-Pointer solution for sorted arrays – O(n) time, O(1) space
 */

package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = {-1, 0};
        TwoSumII twoSumII = new TwoSumII();
        System.out.println(Arrays.toString(twoSumII.twoSum(numbers, -1)));
    }

    /**
     * Brute Force Solution:
     * Try every pair and check if their sum equals the target.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int[] twoSumBruteForce(int[] numbers, int target) {
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * HashMap Solution (for unsorted arrays):
     * Stores visited elements and their indices in a map.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Not optimal for this sorted-input problem.
     */
    public int[] twoSumUnOrderedArray(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int complement = target - number;

            if (map.containsKey(complement)) {
                result[0] = map.get(complement) + 1;
                result[1] = i + 1;
                return result;
            }
            map.put(number, i);
        }

        return result;
    }

    /**
     * Optimized Two-Pointer Solution (for sorted arrays):
     * Use two pointers to find the target sum.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                return new int[]{start + 1, end + 1};
            }

            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[]{-1, -1};
    }
}
