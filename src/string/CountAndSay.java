package string;

public class CountAndSay {

    public static String countAndSay(int n){
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n-1);
        s+="x"; //在最後加入中止符號

        int pointerA =0;
        int pointerB =1;
        String ans = "";

        while(pointerA < s.length() && pointerB <s.length()){
            if(s.charAt(pointerA) != s.charAt(pointerB)){
                ans += (pointerB-pointerA) + String.valueOf(s.charAt(pointerA));
                pointerA = pointerB;
            }
            pointerB++;
        }
        return ans;
    }
    public static String bestSolution(int n){
        if (n == 1) {
            return "1";
        }
        else {
            String ret = bestSolution(n-1);
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            for(int i=0;i<ret.length();i++) {
                //if 已經到底了 或是 下一個與上一個不相等 就把count and number放進去
                if (i==ret.length()-1 || ret.charAt(i) != ret.charAt(i+1)) {
                    sb.append(cnt);
                    sb.append(ret.charAt(i));
                    cnt = 1;
                } else {
                    ++cnt;
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        int n = 6;
        String s = "312211";
        System.out.println(countAndSay(n));
//        System.out.println(Say(s));
    }
}
