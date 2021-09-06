package array;

import java.util.*;

public class IntersectionOfTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = findOutCount(nums1);
        Map<Integer, Integer> map2 = findOutCount(nums2);
        List<Integer> answer = new LinkedList<Integer>();
        answer = checkKey(answer, map2, map1);
        int[]output = new int[answer.size()];
        for(int i=0; i< answer.size(); i++) output[i] = answer.get(i);
        return output;
    }
    public static List<Integer> checkKey(List<Integer> answer, Map<Integer, Integer> bigsize, Map<Integer, Integer> smallsize){
        for(Map.Entry<Integer, Integer> entry: bigsize.entrySet()){
            int key = entry.getKey();
            if(smallsize.containsKey(key)){
                int count = smallsize.get(key) > bigsize.get(key)? bigsize.get(key):smallsize.get(key);
                for(int i=0; i<count; i++)
                    answer.add(key);
            }
        }
        return answer;
    }
    public static Map<Integer, Integer> findOutCount(int[] array){
        Map<Integer,Integer> nums1Map = new HashMap<>();
        for(int i:array){
            if(nums1Map.containsKey(i)) nums1Map.put(i, nums1Map.get(i)+1);
            else nums1Map.put(i, 1);
        }
        return nums1Map;
    }

    /**
     * @param nums1 長度比較長的
     * @param nums2 長度比較短的
     * @return
     */
    public static int[] myanswer(int[] nums1, int[] nums2)
    {
        //好聰明阿!! 竟然用recursion的方式對調順序!!
        if(nums1.length < nums2.length){
            return myanswer(nums2, nums1);
        }
        // 用一個很大的空間，index是key, 內容是代表有幾個 HashMap的幾單版本
        Map<Integer,Integer> map1 = new HashMap<>();
        for(int i:nums1){
            if(map1.containsKey(i)) map1.put(i, map1.get(i)+1);
            else map1.put(i, 1);
        }

        int start = 0;
        //i 是 nums2的每個value
        for(int i: nums2){
            //檢查num1
            if(map1.containsKey(i) && map1.get(i)>0){
                // 直接拿nums當作答案在裡面更改省空間
                nums1[start++] = i;
                //數量少一表示用完
                map1.put(i, map1.get(i)-1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, start);
    }
    public static int[] bestSpeedSolution(int[] nums1, int[] nums2)
    {
        //好聰明阿!! 竟然用recursion的方式對調順序!!
        if(nums1.length < nums2.length){
            return bestSpeedSolution(nums2, nums1);
        }
        int[] arr = new int[1001];
        // 用一個很大的空間，index是key, 內容是代表有幾個 HashMap的幾單版本
        for(int i: nums1){
            arr[i]++;
        }
        int start = 0;
        //i 是 nums2的每個value
        for(int i: nums2){
            //檢查num1
            if(arr[i] > 0){
                // 直接拿nums當作答案在裡面更改省空間
                nums1[start++] = i;
                //數量少一表示用完
                arr[i]--;
            }
        }
        return Arrays.copyOfRange(nums1, 0, start);
    }
    public static int[] bestMemorySolution(int[] nums1, int[] nums2) {
        // Position the smaller array first.
        if(nums1.length > nums2.length) {
            return bestMemorySolution(nums2, nums1);
        }

        int[] retval = new int[nums1.length];

        Arrays.sort(nums1);  // n log(n)
        Arrays.sort(nums2);  // n log(n)

        //三個陣列的指標
        int x = 0; //nums1 比較長
        int y = 0; //nums2 比較短
        int k = 0; //解答

        //如果num1, num2 指標還在正常範圍內 就繼續
        while(x < nums1.length && y < nums2.length) {
            //如果目前雙方指標指到的Value是一樣的大家都可以往前下一格
            if(nums1[x] == nums2[y]) {
                //把答案放進去
                retval[k] = nums1[x];
                //大家都可以往前下一格
                k++;
                x++;
                y++;
            //如果發現 nums1指標的數字太小 代表nums1該往下一個較大的數字看
            } else if(nums1[x] < nums2[y]) {
                x++; //nums1 pointer go to next step
            } else { // nums1[y] > nums2[x] 以此類推
                y++;
            }
        }

        System.gc();
        return Arrays.copyOfRange(retval,0,k);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {1,1};
        System.out.println(Arrays.toString(bestMemorySolution(nums1, nums2)));
    }
}
