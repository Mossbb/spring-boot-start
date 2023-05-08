package com.ryytn.start.web;

import java.util.Arrays;

public class CouponOptimizer {

    public static int minTotalPrice(int[][] prices, int[][] coupons) {
        int n = prices.length;
        int m = coupons.length;

        // Step 2: Calculate minimum price without coupons
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + prices[i - 1][0], dp[i - 1] + prices[i - 1][1]);
        }

        // Step 3: Backtracking
        int[] minTotal = {dp[n]};
        Arrays.sort(coupons, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(b[1], a[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        // Create a memo array and initialize it with -1，100为最大商品单价
        int[][] memo = new int[n][n * 100 + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        backtrack(prices, coupons, 0, 0, minTotal, memo);

        // Step 4: Return the minimum total price
        return minTotal[0];
    }

    private static void backtrack(int[][] prices, int[][] coupons, int current, int total, int[] minTotal, int[][] memo) {
        int n = prices.length;

        if (current == n) {
            for (int[] coupon : coupons) {
                if (total >= coupon[0]) {
                    minTotal[0] = Math.min(minTotal[0], total - coupon[1]);
                    break;
                }
            }
            return;
        }

        // 如果已经计算过该子问题，直接返回结果
        if (memo[current][total] != -1) {
            minTotal[0] = Math.min(minTotal[0], memo[current][total]);
            return;
        }

        for (int price : prices[current]) {
            backtrack(prices, coupons, current + 1, total + price, minTotal, memo);
        }

        // 记录子问题的结果
        memo[current][total] = minTotal[0];
    }

    private static void backtrack(int[][] prices, int[][] coupons, int current, int total, int[] minTotal) {
        int n = prices.length;

        if (current == n) {
            for (int[] coupon : coupons) {
                if (total >= coupon[0]) {
                    minTotal[0] = Math.min(minTotal[0], total - coupon[1]);
                    break;
                }
            }
            return;
        }

        for (int price : prices[current]) {
            backtrack(prices, coupons, current + 1, total + price, minTotal);
        }
    }

    public static void main(String[] args) {
        int[][] prices = {{10, 8}, {20, 18}, {30, 25}};
        int[][] coupons = {{51, 7}, {60, 17}, {100, 20}};
        System.out.println(minTotalPrice(prices, coupons));
    }
}