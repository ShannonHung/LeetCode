package array;

import java.util.Arrays;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,100};
        Solution solution = new Solution();
        System.out.println(solution.bestSpeedSoultion(nums));
    }
}
class Solution{
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) return true;
        }
        return false;
    }
    public boolean bestSpeedSoultion(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        // get max and min
        for(int i=1;i<nums.length;i++) {
            if(nums[i]<min) {
                min = nums[i];
            }
            if(nums[i]>max) {
                max = nums[i];
            }
        }

        boolean[] checkArray = new boolean[max-min+1];
        for(int i=0;i<nums.length;i++) {
            if(checkArray[nums[i] - min]) {
                return true;
            }
            checkArray[nums[i] - min] = true;
        }

        return false;

    }
}