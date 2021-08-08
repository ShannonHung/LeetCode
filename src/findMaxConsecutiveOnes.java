import java.util.Arrays;

public class findMaxConsecutiveOnes {
    /**
     * 1ms 速度 38M 最小容量的最佳解
     * @param nums
     * @return
     */
    public static int BestSolution(int[] nums) {
        int maxNum = 0;
        int count = 0;
        if (nums == null || nums.length == 0) return 0;
        for(int i = 0; i < nums.length ; i++) {
            if(nums[i] == 1){
                count++;
                if(count>maxNum) maxNum = count;
            }
            else count = 0;
        }
        System.gc(); //拿掉就可以變成1ms 最快速度
        return maxNum;
    }

    public static void main(String[] args) {
        int[] test = {1};
        System.out.println(BestSolution(test));
    }
}
