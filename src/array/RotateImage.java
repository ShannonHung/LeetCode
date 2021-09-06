package array;

import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {
     //upside down
     int pointer1 = 0;
     int pointer2 = matrix.length-1;
     while(pointer1 < pointer2){
         int[] tmp = matrix[pointer1];
         matrix[pointer1++] = matrix[pointer2];
         matrix[pointer2--] = tmp;
     }

     for(int i =0; i < matrix.length-1; i++){
         int j = i+1;
         while(j<matrix[i].length){
//             System.out.println("row "+i+" => " + j++);
             int tmp = matrix[i][j];
             matrix[i][j] = matrix[j][i];
             matrix[j][i] = tmp;
             j++;
         }
     }
    }
    public static void bestMemorySolution(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i<(n+1)/2; i++){
            for(int j =0; j< n/2; j++){
                int temp= matrix[n-1-j][i];
                System.out.printf("temp => matrix[%s,%s](%s)\n", n-1-j, i, temp);
                System.out.printf("change => m[%s,%s](%s) = m[%s,%s](%s)\n", n-1-j, i, matrix[n-1-j][i], n-i-1, n-j-1, matrix[n-i-1][n-j-1]);
                matrix[n-1-j][i] = matrix[n-i-1][n-j-1];
                System.out.printf("change2 => m[%s,%s](%s) = m[%s,%s](%s)\n", n-i-1, n-j-1,matrix[n-i-1][n-j-1], j, n-i-1,matrix[j][n-i-1]);
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                System.out.printf("change3 => m[%s,%s](%s) = m[%s,%s](%s)\n", j, n-i-1, matrix[j][n-i-1], i, j, matrix[i][j]);
                matrix[j][n-i-1] = matrix[i][j];
                System.out.printf("change4 => m[%s,%s](%s) = tmp(%s)\n", i, j, matrix[i][j],temp);
                matrix[i][j] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        bestMemorySolution(matrix);
    }
}
