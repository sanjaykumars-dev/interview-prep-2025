/**
 * LeetCode Problem : Move Zeroes
 * https://leetcode.com/problems/move-zeroes/description/
 * Contains both brute force and optimized solution.
 */

package arrays;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));  // Output: [1, 3, 12, 0, 0]
    }

    /**
     * Brute Force Approach:
     * - Create a temporary array and copy all non-zero elements.
     * - Then fill the rest with zeroes.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public void moveZeroesBruteForce(int[] nums) {
        int[] temp = new int[nums.length];
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                temp[i++] = nums[j];
            }
        }
        for (int k = 0; k < nums.length; k++) {
            nums[k] = temp[k];
        }
    }

    /**
     * Optimized Approach:
     * - Use two pointers. One pointer tracks where the next non-zero should go.
     * - Iterate the array and swap non-zero elements to the left.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void moveZeroes(int[] nums) {
        int pointZero = 0; // Index to place the next non-zero number

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != pointZero) {
                    swap(nums, i, pointZero);
                }
                pointZero++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
