package hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {

    public static void main(String[] args) {
        List<Integer> integers = new Solution54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        for(int cur:integers){
            System.out.println(cur);
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int line = matrix.length;
        int row = matrix[0].length;

        List<Integer> ans = new ArrayList<>();
        handle(matrix, 0, line - 1, 0, row - 1, ans);
        return ans;

    }

    public void handle(int[][] matrix, int firL, int lastL, int firR, int lastR, List<Integer> ans){
        if(firL > lastL || firR > lastR) return;

        if(firR <= lastR){
            for(int i = firR ; i <= lastR ; i++){
                ans.add(matrix[firL][i]);
            }
        }
        if(firL < lastL - 1){
            for( int i = firL + 1 ; i <= lastL - 1 ; i++){
                ans.add(matrix[i][lastR]);
            }
        }
        if(firL < lastL && firR <= lastR){
            for(int i = lastR ; i >= firR ; i--){
                ans.add(matrix[lastL][i]);
            }
        }
        if(firR < lastR && firL < lastL - 1){
            for(int i = lastL - 1 ; i >= firL + 1 ; i --){
                ans.add(matrix[i][firR]);
            }
        }

        handle(matrix, firL+1, lastL-1, firR+1, lastR-1, ans);
    }

}
