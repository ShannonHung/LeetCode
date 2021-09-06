package string;

public class StringtoInteger {
    public static int myAtoi(String str) {
        if (str.isEmpty()) return 0;
        //sign 決定 正負號
        //base 來計算要Return的值
        //i表示現在在第幾個char
        int sign = 1, base = 0, i = 0, n = str.length();
        //空白開頭
        while (i < n && str.charAt(i) == ' ') ++i;
        //正負號開頭
        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }
        //如果是數字 char 在 0-9之間 我們就把它10
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            //如果正整數或是負整數 超過範圍
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }

    public static void main(String[] args) {
        String s ="4193 with words";
        System.out.println(myAtoi(s));
    }
}
