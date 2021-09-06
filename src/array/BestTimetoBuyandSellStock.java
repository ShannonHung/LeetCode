package array;

public class BestTimetoBuyandSellStock {
    //1ms
    public static int maxProfit(int[] prices) {
        int profit =0;
        int current=0;
        for(int i = 1; i < prices.length; i++){
            if(prices[current] <= prices[i]){
                profit += prices[i] - prices[current];
            }
            current=i;
        }

        return profit;
    }

    //0ms
    public static int bestSpeedSolution(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(nums));
    }
}
