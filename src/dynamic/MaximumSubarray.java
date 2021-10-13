package dynamic;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int cur_max = nums[0];
        int global_max = nums[0];
        for(int i = 1; i < nums.length; i++){
            cur_max = Math.max(nums[i], nums[i]+cur_max);
            global_max = Math.max(cur_max, global_max);
        }
        return global_max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }
}
