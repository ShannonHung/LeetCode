package array;

import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int point1 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=0){
                int temp = nums[point1];
                nums[point1++] = nums[i];
                nums[i] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void bestmemorySolution(int[] nums) {
        int i=0;
        int j=0;
        while(nums.length>j){
            if(nums[j]!=0){
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
            j++;
        }
        System.gc();

    }
    public static void moveZeroes2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[index++] = nums[i];
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
    public static void main(String[] args) {
        int[] test = new int[]{1,1,1,3,12};
        moveZeroes(test);
//        System.out.println(Arrays.toString(moveZeroes(test)));
    }
}
