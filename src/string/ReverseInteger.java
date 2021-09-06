package string;

import java.util.Arrays;

public class ReverseInteger {
    public static int reverse(int x) {
        if(x>0&&x<10) //只有一個正數的時候直接回傳
            return x;
        long reverse = 0; //題目會給 int溢出的大小數值
        while(x!=0){ //x>0 and x<0 都要執行 所以就是 !=0
            reverse*=10; //把原本已存的數值*10留位子給尾數: 從尾數開始取 * 10 每次
            reverse += x%10; //加上尾數: 尾數*10之後+新尾數
            x/=10; //更新目前尾數: x=123 => x=12 => x=1
        }
        if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)
            return 0; //溢位要直接回傳0

        return (int)reverse;  //要強制轉型
    }
    public static int bestSolution(int x) {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result){
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
    public static void main(String args[]){
        System.out.println(bestSolution(-123));
    }
}
