package array;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {

    //1ms
    public static int removeDuplicates(int[] nums) {
        //要注意的是他是要把數字插進去nums裡面 假如發現新的數字 那就要放在原本數字的下一個 [1.1.2.2] 要變成 [1.2.2.2]
        if(nums.length == 0) return 0;
        int location = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[location] != nums[i+1]){
                location++;
                nums[location] = nums[i+1];
            }
        }
        return location+1;
    }

    //0ms
    public static int bestSpeedSolution(int[] nums) {
        if(nums.length==0) return 0;
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }



        public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}
