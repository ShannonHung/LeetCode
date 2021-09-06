package string;

public class ImplementStr {
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    public static int BestSpeedSolution(String haystack, String needle) {
        if (haystack=="") return 0;
        //haystack 一個個前進看 每次一組needle
        for(int i=0; i <(haystack.length() - needle.length()+1); i++){
            if(haystack.substring(i, i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "bba";
        System.out.println(strStr(haystack, needle));
    }
}
