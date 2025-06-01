/**
 * LeetCode Problem : Maximum SubArray
 * https://leetcode.com/problems/maximum-subarray/description/
 * contains both brute force and optimized solution
 */

package main.java.arrays;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.findLargestSum(nums));
    }

    /**
     * Brute Force Approach:
     * Iterate through all possible subarrays of the input array.
     * For each subarray, calculate the sum and track the maximum sum seen so far.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */

    public int findLargestSumBruteForce(int[] nums){
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i< nums.length; i++){
            int sum = 0;
            for(int j=i; j< nums.length; j++){
                sum += nums[j];
                maxSum = Math.max(maxSum,sum);
            }
        }
        return maxSum;
    }

    /**
     * Kadane’s Algorithm:
     * Iterate through the array, at each step, decide whether to start a new subarray
     * or extend the existing subarray by including the current element.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public int findLargestSum(int[] nums){
        int maxSum = nums[0];
        int currentSum = nums[0];
        for(int i=1; i<nums.length; i++){
            currentSum = Math.max(nums[i], currentSum+nums[i]);
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }

    /**
     * When to use Kadane's Algorithm?
     * - When you need to find the maximum (or minimum) sum of a contiguous subarray.
     * - The array may contain negative integers.
     * - You want to solve the problem in linear time O(n).
     * - The subarray must be contiguous (no skipping elements).
     * - The array cannot be sorted or rearranged.
     */
}
