package array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateArray {

    //wrong answer
    public static void rotate(int[] nums, int k) {

            int[] newnums = new int[nums.length];
            int count = 0;

            for(int i = 0; i < k; i++){
                newnums[i] = nums[nums.length-k+i];
            }
            for(int i = k; i < nums.length; i++){
                newnums[i] = nums[count];
                count++;
            }
            for(int i = 0 ; i < newnums.length; i++) {
                nums[i] = newnums[i];
            }
            System.out.println(Arrays.toString(nums));

    }

    public static void bestSolution(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     *
     * @param nums 原本陣列 in order to in-place
     * @param i 開始
     * @param j 結束
     */
    private static void reverse(int[] nums, int i, int j){
        int tmp = 0;
        while(i < j) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        int k = 2;
        bestSolution(nums, k);
    }
}
