package string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s){
        String[] s_array = s.split("");
        HashMap<String, Integer> s_map = new HashMap<>();
        for(String v:s_array){
            s_map.put(v, s_map.get(v) == null? 1:s_map.get(v)+1);
        }
        for(int i =0; i < s_array.length; i++){
            if(s_map.get(s_array[i]) == 1 ) return i;
        }
        return -1;
    }
    public static int solution1(String s){
        Map<Character, Integer> tm = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++){
            Character curr = s.charAt(i);
            tm.put(curr, tm.getOrDefault(curr, 0) + 1);
        }
        int res = -1;
        for(Map.Entry entry: tm.entrySet()) {
            if((int) entry.getValue() == 1) {
                Character unique = (Character) entry.getKey();
                res = s.indexOf(unique);
                break;
            }
        }
        return res;
    }
    public static int solution2(String s){
        int n = s.length();
        for(int first = 'a'; first <= 'z'; first++){
            int i = s.indexOf(first);
            //if exist and index is only one, we use n to store the biggest index
            if(i != -1 && i == s.lastIndexOf(first)) n = Math.min(n,i);
        }
        //if n hasn't changed, means there are no unique char
        return n == s.length() ? -1 : n;
    }
    public static void main(String args[]){
        String s = "loveleetcode";
        System.out.println(solution2(s));
    }
}
