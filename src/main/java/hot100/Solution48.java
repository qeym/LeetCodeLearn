package hot100;

import java.util.Arrays;

public class Solution48 {
    public void rotate(int[][] matrix) {
        //水平
        for(int i = 0 ; i < matrix.length/2 ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - i - 1][j];
                matrix[matrix.length - i - 1][j] = temp;
            }
        }
        //对角
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix.length - i ; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
