/**
 * LeetCode Problem : Product of the array except self
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * Contains both brute force and optimized solution
 * */

package arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(nums)));
    }

    /**
     * Brute Force Approach :
     * Iterate through the array.
     * If i != j, calculate the product and update the result[]
     * Return the result array
     * Time Complexity - O(n^2)
     * Space Complexity - O(n)
     * */

    public int[] productExceptSelfBruteForce(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i< nums.length; i++){
            int product = 1;
            for(int j = 0; j< nums.length; j++){
                if(i != j){
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }

    /**
     * Optimized Approach:
     * Step 1: Traverse from left to right and store prefix products.
     * Step 2: Traverse from right to left and multiply suffix product on the fly.
     * Time Complexity: O(n)
     * Space Complexity: O(1) (excluding result array)
     */

    public int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i=1; i < nums.length; i++){
            result[i] = result[i-1] * nums[i-1];
        }
        int suffix = 1;
        for(int i = nums.length-1; i>=0 ; i--){
            result[i] = result[i] * suffix;
            suffix *= nums[i];
        }
        return result;
    }
}
