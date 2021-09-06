package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
    public static int[] bestSpeedSolution(int[] nums, int target)
    {
        for (int i = 1; i < nums.length; i++)
            for (int j = i; j < nums.length; j++)
                if (nums[j] + nums[j - i] == target)
                    return new int[]{j - i, j};

        return null;
    }
    public static int[] bestSpeedSolution2(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int requiredNum = target - nums[i];

            if (indexMap.get(requiredNum) != null) {
                result[0] = indexMap.get(requiredNum);
                result[1] = i;
                break;
            } else {
                //key: array的值, value: index
                indexMap.put(nums[i], i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] test = new int[]{-1,-2,-3,-4,-5};
        int target = -6;
//        twoSum(test,4);
        System.out.println(Arrays.toString( bestSpeedSolution(test,target)));
    }
}
