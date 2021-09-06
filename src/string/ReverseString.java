package string;

import java.util.Arrays;

public class ReverseString {
    public static void reverseString(char[] s){
        int n = s.length;
        for(int i=0; i<n/2; i++){
            char tmp = s[i];
            s[i] = s[n-1-i];
            s[n-1-i] = tmp;
        }
        System.out.println(Arrays.toString(s));
    }
    public static void main(String args[]){
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
    }
}
