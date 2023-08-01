package hot100;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0,y = matrix[0].length;
        while (x > 0 && y > 0){
            if(matrix[x][y] == target) return true;
            if(matrix[x][y] > target){
                y--;
            }else{
                x++;
            }
        }
        return false;
    }
}
