package 买卖股票的最佳时机;

import java.util.Arrays;

public class Solution {

    //动态规划

    /**
     *每天有两种状态：持有股票不持有股票
     * dp[i][0]=max{dp[i-1][0],dp[i-1][1]+price[i]}
     * dp[i][1]=max{dp[i-1][1],dp[i-1]-price[i]}
     * 初始状态dp[0][0]=0 dp[0][1]=-price[0]
     *
     *
     */
    public int maxProfit(int[] prices) {

        if (prices.length<2){
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];

        for (int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public int maxProfit2(int[] prices) {
        int max=0;
        for (int i=0;i<prices.length-1;i++){
            for (int j=i+1;j<prices.length;j++){
                if (prices[j]-prices[i]>max){
                    max=prices[j]-prices[i];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
