package string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n-1;
        int[] map = new int[256];
//int[] 前面塞0-9位置塞數字1-10
        for (int i = '0'; i <= '9'; i++) {
            map[i] = i + 1;
        }
//int[] 'a'-'z'的位置塞數字11~
        for (int i = 'a'; i <= 'z'; i++) {
            map[i] = i - 'a' + 11;
        }
//同上先確保0-9 跟a-z
        for (int i = 'A'; i <= 'Z'; i++) {
            map[i] = i - 'A' + 11;
        }
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            //如果雙方都沒有這個字母 就往前繼續比較
            if (map[leftChar] == 0 && map[rightChar] == 0) {
                left++;
                right--;
            } else if (map[leftChar] != 0 && map[rightChar] != 0) {
                if (map[leftChar] != map[rightChar]) {
                    return false;
                }
                left++;
                right--;
            } else {
                if (map[leftChar] == 0) {
                    left++;
                }
                if (map[rightChar] == 0) {
                    right--;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s2 = "ab_a";
        System.out.println(isPalindrome(s));
    }
}
