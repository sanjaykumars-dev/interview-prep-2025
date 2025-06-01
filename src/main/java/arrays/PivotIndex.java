/**
 * LeetCode Problem : Find the Pivot Index
 * https://leetcode.com/problems/find-pivot-index/description/
 */

package main.java.arrays;

public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        PivotIndex pivotIndex = new PivotIndex();
        System.out.println(pivotIndex.pivotIndex(nums));
    }

    /**
     * Brute Force Approach:
     * - For each index, calculate the sum of elements on the left and right.
     * - If they are equal, return the current index.
     * - Time Complexity: O(n^2)
     */

    public int pivotIndexBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Optimized Approach:
     * - First, calculate the total sum of the array.
     * - Traverse the array while maintaining a running leftSum.
     * - The rightSum at any index can be derived as: totalSum - leftSum - currentElement
     * - If leftSum == rightSum, return the index.
     * - Time Complexity: O(n)
     */

    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;
        int rightSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        for(int i = 0; i < nums.length; i++){
            rightSum = totalSum - leftSum - nums[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
