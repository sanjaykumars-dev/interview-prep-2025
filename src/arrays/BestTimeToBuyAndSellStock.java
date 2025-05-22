/**
 * LeetCode Problem: Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Contains both brute-force and optimized solutions.
 */

package arrays;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock buyOrSell = new BestTimeToBuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(buyOrSell.maxProfit(prices));
    }

    /**
     * Brute Force Approach:
     * Try every possible pair of buy and sell days.
     * Track the maximum profit from all such pairs.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */

    public int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for(int i=0;i < prices.length;i++){
            for(int j=i+1; j < prices.length;j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit,profit);
            }
        }
        return maxProfit;
    }


    /**
     * Optimized Approach:
     * Track the minimum price seen so far and calculate profit at each step.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPriceSoFar = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPriceSoFar);
        }

        return maxProfit;
    }
}
