/**
 * LeetCode Problem: Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * Includes both brute-force and optimal approach.
 */

package arrays;

public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        MinimumSizeSubArraySum solution = new MinimumSizeSubArraySum();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(solution.minSubArrayLenBruteForce(11, nums)); // Output: 3
    }

    /**
     * Brute Force Approach:
     * Iterate through all possible subarrays and calculate their sums.
     * If the sum is greater than or equal to target, update minLength.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int minSubArrayLenBruteForce(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum >= target) {
                    minLength = Math.min(minLength, end - start + 1);
                    break;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /**
     * Optimal Approach:
     * Use Sliding Window to expand and contract the window to find minimal subarray with sum ≥ target.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
