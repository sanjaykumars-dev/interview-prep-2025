/**
 * LeetCode Problem: Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 * Contains both brute force and optimized solution.
 */

package arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(heights));
    }

    /**
     * Brute Force Approach :
     * Find the Max Area of every possible pair.
     * Time Complexity : O(n^2)
     * Space Complexity : O(1)
     */

    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        for(int i = 0; i<height.length; i++){
            for(int j = i+1; j<height.length; j++){
                int minHeight = Math.min(height[i],height[j]);
                int width = j - i;

                maxArea = Math.max(maxArea,minHeight*width);
            }
        }
        return maxArea;
    }

     /**
     * Optimized Approach:
     * - Use two pointers starting from both ends of the array.
     * - Calculate area using the shorter height and current width.
     * - Move the pointer at the shorter height inward (because width reduces, and we want to try for a taller line).
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int minHeight = Math.min(height[start], height[end]);
            int width = end - start;
            int area = minHeight * width;

            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter height
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }

}
