package dynamic;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

//        return climbStairs(n-1)+climbStairs(n-2);
        int pre_step = 2;
        int pre_pre_step = 1;
        int cur_step = 3;
        for(int i = 2; i < n; i++){
            cur_step = pre_pre_step + pre_step;
            pre_pre_step = pre_step;
            pre_step = cur_step;
        }
        return cur_step;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
