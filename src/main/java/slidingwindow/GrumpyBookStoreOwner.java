/**
 * LeetCode Problem: Grumpy Book Store Owner
 * URL: https://leetcode.com/problems/grumpy-bookstore-owner/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

package main.java.slidingwindow;

public class GrumpyBookStoreOwner {

    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;

        GrumpyBookStoreOwner grumpyBookStoreOwner = new GrumpyBookStoreOwner();
        int result = grumpyBookStoreOwner.maxSatisfied(customers, grumpy, minutes);

        System.out.println("Maximum Satisfied Customers: " + result);
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalSatisfied = 0;

        // Step 1: Calculate baseline satisfaction (when the owner is not grumpy).
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            }
        }

        // Step 2: Use sliding window to find the best time to apply the technique.
        int extraSatisfied = 0;
        int maxExtraSatisfied = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                extraSatisfied += customers[i];
            }

            if (i >= minutes && grumpy[i - minutes] == 1) {
                extraSatisfied -= customers[i - minutes];
            }

            maxExtraSatisfied = Math.max(maxExtraSatisfied, extraSatisfied);
        }

        return totalSatisfied + maxExtraSatisfied;
    }
}
