package searchandsort;

import java.util.Arrays;

public class FirstBadVersion {
    public static boolean isBadVersion(int version){
        int ans= 2;
        return version >= ans;
    }
    public static int firstBadVersion(int n) {
        int max = n;
        int min = 0;
        int mid = 0;
        while(min < max){
            mid = max+min >>> 1;
            if(!isBadVersion(mid)) min = mid+1;
            else max=mid;
        }
        return mid;
    }
    public static int bestSolution(int n){
        int min = 1, max = n;
        while (min < max) {
            int mid = (max+min) >>> 1;
            if (!isBadVersion(mid)) min = mid + 1;
            else max = mid;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(bestSolution(5));
    }
}
