package array;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int length = digits.length-1;
        for(int i = length; i >= 0; i--){
            if(digits[i]< 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[length+2];
        digits[0] = 1;
        return digits;
    }
    public static void main(String[] args) {
        int[] test = new int[]{9};
        System.out.println(Arrays.toString(plusOne(test)));
    }
}
