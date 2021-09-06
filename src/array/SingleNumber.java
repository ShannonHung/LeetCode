package array;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(result.containsKey(nums[i])) result.put(nums[i], result.get(nums[i])+1);
            else result.put(nums[i], 1);
        }
        for(int i = 0; i < nums.length; i++){
            if(result.get(nums[i]) == 1) return nums[i];
        }
        return 0;
    }
    public static int bestSpeedSolution(int[] nums) {
        int res = 0;
        for(int i =0; i<nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] test = {4,1,2,1,2};
        System.out.println(bestSpeedSolution(test));
    }
}
