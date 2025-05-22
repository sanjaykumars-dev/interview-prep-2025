// Problem : https://leetcode.com/problems/two-sum/
package arrays;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum solver = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solver.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }


    /* Brute Force Approach:
     * Iterate through every element in the array.
     * If their sum adds up to the target, return their indices.
     * Time Complexity: O(n^2)
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /* Optimized Approach:
     * Initialize a HashMap to store number and its index.
     * Iterate through each element in the array.
     * If the complement exists in the map, return its index and current index.
     * Else, store the number with its index.
     * Time Complexity: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result[0] = i;
                result[1] = map.get(complement);
                return result;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }
}
