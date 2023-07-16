import java.util.Arrays;

class Solution {
    public static int maxProfit1(int[] prices, int start, int end) {
        int profit = 0;
        int min_price = prices[start];
        for (int i = start; i < end; i++) {
            if (min_price > prices[i]) {
                min_price = prices[i];
                continue;
            }
            if (prices[i] - min_price > profit) {
                profit = prices[i] - min_price;
            }
        }
        return profit;

    }
    public static int minSumOfSubarray(int[] arr, int start, int end){
        int global_sum = 0;
        int local_sum = 0;
        for (int i = start; i < end; i++) {
            local_sum = Math.min(arr[i], local_sum + arr[i]);
            global_sum = Math.min(local_sum, global_sum);
        }
        return global_sum;
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] differences = new int[n - 1];
        int[] balance = {0, 0};
        int profit = 0;
        int prev_min_index = 0;
        for (int i = 1; i < n; i++) {
            differences[i - 1] += prices[i] - prices[i - 1];
            if (prices[i] < prices[prev_min_index]){
                prev_min_index = i;
                continue;
            }
            if (prices[i] - prices[prev_min_index] > profit){
                profit = prices[i] - prices[prev_min_index];
                balance[0] = prev_min_index;
                balance[1] = i;
            }
        }
        int dif = minSumOfSubarray(differences, balance[0],  balance[1] - 1);
        int dif2 = Math.max(Solution.maxProfit1(prices, 0, balance[0]), Solution.maxProfit1(prices, balance[1], n));
//        System.out.println("differences:" + Arrays.toString(differences) +" between " + Integer.toString(balance[0]) + ", " + Integer.toString(balance[1] - 1));
//        System.out.print("dif2 :");
//        System.out.println(dif2);
//        System.out.print("profit:");
//        System.out.println(profit);
//        System.out.print("dif:");
//        System.out.println(dif);
        profit = Math.max(dif2 + profit, profit - dif);
        return profit;

    }
}