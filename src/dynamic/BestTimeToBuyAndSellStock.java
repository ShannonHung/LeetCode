package dynamic;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
    public static int maxProfit2 ( int[] prices){
        // min代表目前股票出現的最低價，一開始用MAX_SAFE_INTEGER表示無限大
        int min = Integer.MAX_VALUE;

        // 目前獲利
        var profit = 0;

        for(var i = 0; i < prices.length ; i++){
            // 找出最低點買進
            if(prices[i] < min){
                min = prices[i];
            }

            // 計算現在的價錢可以獲利多少
            int calProfit = prices[i] - min;
            // 現在的價錢賣出是否可以獲得更高的獲利
            if(calProfit > profit ){
                profit = calProfit;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        maxProfit(price);
    }
}
