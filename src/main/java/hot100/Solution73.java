package hot100;

import java.util.HashMap;

public class Solution73 {
    public static void main(String[] args) {
        new Solution73().setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
    public void setZeroes(int[][] matrix) {
        HashMap<Integer, Boolean> lineMap = new HashMap<>();
        HashMap<Integer, Boolean> rowMap = new HashMap<>();
        for(int i = 0 ; i < matrix.length ; i ++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    lineMap.put(i,true);
                    rowMap.put(j,true);
                }
            }
        }
        for(int i = 0 ; i < matrix.length ; i ++) {
            for (int j = 0; j < matrix.length; j++) {
                if(lineMap.containsKey(i) || rowMap.containsKey(j)){
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
