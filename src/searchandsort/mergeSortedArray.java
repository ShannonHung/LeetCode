package searchandsort;

import java.util.Arrays;

public class mergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i < n; i++){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
    public static void bestSolution(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1; // 從 nums1最大數 開始
        int j = n-1; //從 nums2 最大數 開始
        int k = m+n-1; //如果 nums2的 max 比 nums1的max大，我們就擺nums1的最後 k

        //if nums1 and nums2 still in range
        while( i >= 0 && j >= 0){
            if(nums1[i] > nums2[j])
                nums1[k--] = nums1[i--]; //nums1 內部自己移動 開始把 大的整排往後移動
            else
                nums1[k--] = nums2[j--];
        }
        while( j>= 0)
            nums1[k--] = nums2[j--];
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        bestSolution(nums1, m, nums2, n);
    }
}
