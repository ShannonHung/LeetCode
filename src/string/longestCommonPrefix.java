package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        Map<String, Integer> cnt = new HashMap<>();
        String ans = "";
        int biggest = 0;
        for(int i =0; i <= strs[0].length(); i++){
            String target = strs[0].substring(0, i);
            for(String v: strs){
                if(v.indexOf(target) == 0){
                    cnt.put(target, cnt.getOrDefault(target, 0)+1);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            int value = entry.getValue();
            if( value == strs.length && ans.length() <= entry.getKey().length()) {
                ans = entry.getKey();
            }
        }
        return ans;
    }
    public static String bestSpeedSolution(String[] strs) {

        if(strs.length ==1) return strs[0];

        Arrays.sort(strs);

        int c=0;
        String first=strs[0];
        String last = strs[strs.length-1];

        while(c<first.length() && first.charAt(c)==last.charAt(c)) c++;

        return c>0?first.substring(0,c):"";

    }

    public static void main(String[] args) {
        String[] s = {"flower", "flower", "flower"};
        System.out.println(
            bestSpeedSolution(s)
        );
    }
}
