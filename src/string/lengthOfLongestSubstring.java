package string;

import java.util.HashMap;

public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int maxlength = 0;
        int strlen = s.length();
        int restartPointer = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int currentPointer = 0; currentPointer < strlen; currentPointer++){
            if(map.containsKey(s.charAt(currentPointer))){
                //如果以前出現過的 要從 以前出現過的下一個開始數 restartPointer = 以前出現過的下一個開始數 (e.g. dvdf)
                //restartPointer不可以走回頭路 (e.g. abba) 碰到最後的a 他會回去找第一個a 但是此時的restartPointer在最後一個b
                restartPointer = Math.max(restartPointer,map.get(s.charAt(currentPointer)) + 1);
            }
            map.put(s.charAt(currentPointer), currentPointer);
            maxlength = Math.max(maxlength, currentPointer - restartPointer + 1); //目前最大, 目前不重複的長度

        }
        return maxlength;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
