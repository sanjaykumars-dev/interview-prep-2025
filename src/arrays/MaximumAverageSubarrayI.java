/**
 * LeetCode Problem :  Maximum Average Subarray I
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 * Contains both brute force and optimized solutions
 */

package arrays;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();
        System.out.println(maximumAverageSubarrayI.findMaxAverageBruteForce(nums,1));
    }

    /**
     * Brute Force Approach:
     * - For every possible subarray of length 'k', calculate the sum.
     * - Convert the sum to average and track the maximum average found.
     * - Time Complexity: O(n * k)
     * - Space Complexity: O(1)
     */

    public double findMaxAverageBruteForce(int[] nums, int k) {
        double maxAverage = Double.NEGATIVE_INFINITY;

        for (int i = 0; i <= nums.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            double average = (double) sum / k;
            maxAverage = Math.max(maxAverage, average);
        }

        return maxAverage;
    }

    /**
     * Optimized Approach (Sliding Window):
     * - Compute the sum of the first 'k' elements.
     * - Slide the window one element at a time by subtracting the element
     *   that is leaving the window and adding the new element.
     * - Keep track of the maximum sum and compute average at the end.
     * - Time Complexity: O(n)
     * - Space Complexity: O(1)
     */

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }

}
