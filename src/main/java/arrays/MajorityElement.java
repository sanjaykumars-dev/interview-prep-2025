/**
 * LeetCode Problem : Find the majority element.
 * https://leetcode.com/problems/majority-element/description/
 * Contains both brute force and optimized approach.
 */

package main.java.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(nums));
    }

    /**
     *  Brute Force Approach:
     * For each element, count its frequency by looping the entire array again.
     * If any element's count exceeds n/2, return it.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int majorityElementBruteForce(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }

    /**
     * Optimized Approach using HashMap:
     * Count the frequency of each element while iterating.
     * Return the element once its count exceeds n/2.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        int majority = nums.length / 2;

        for(int i=0; i<nums.length; i++){
            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
            if(freqMap.get(nums[i]) > majority){
                return nums[i];
            }
        }
        return -1;
    }
}
