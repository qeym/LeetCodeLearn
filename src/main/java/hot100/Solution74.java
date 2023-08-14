package hot100;

public class Solution74 {

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = new int[][]{{1}};
        boolean b = new Solution74().searchMatrix(matrix, 1);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int line = matrix.length;
        int row = matrix[0].length;

        int start = 0;
        int end = line*row - 1;
        while(start <= end){
            int mid = (start + end)/2;
            int curLine = mid/row;
            int curRow = mid%row;

            if(matrix[curLine][curRow] == target) return true;
            else if(matrix[curLine][curRow] < target){
                start = mid+1;
            }else if(matrix[curLine][curRow] > target){
                end = mid-1;
            }

        }

        return false;
    }
}
