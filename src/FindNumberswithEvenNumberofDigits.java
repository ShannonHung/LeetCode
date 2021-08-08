/**
 * Given an array nums of integers, return how many of them contain an even number of digits.
 *
 * //Example 1:
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 *
 * //Example 2:
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 */
public class FindNumberswithEvenNumberofDigits {
    public static int findNumbers(int[] nums) {
        int evenCount = 0;
        for(int i : nums) {
            int numLength = String.valueOf(i).length();
            if(numLength % 2 == 0) evenCount++;
        }
        return evenCount;
    }
    public static int BestSpeedSolution(int[] nums) {
        int evenCount=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]>9 &&nums[i]<=99) || (nums[i]>999 && nums[i]<=9999) ||nums[i]==100000)
                evenCount++;
        }
        return evenCount;
    }

    public static void main(String[] args) {
        int[] test = new int[]{555,901,482,1771};
        System.out.println(findNumbers(test));
    }
}