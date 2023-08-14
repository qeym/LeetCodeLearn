package hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution51 {

    public static void main(String[] args) {
        new Solution51().solveNQueens(1);
    }

    List<List<String>> ans;
    List<String> cur;
    boolean[] access;

    //记录右上走向的斜线是否有值，由于右上的斜线方程为y-x=b(x和y表示点的坐标),即记录b值即可
    //b值范围是（-n,n）
    boolean[] accessMinus;
    //类似上值，记录右下走向的斜线是否有值，由于右下走向的斜线方程为y+x=c,即记录c值即可
    //c值范围是（0，2n）
    boolean[] accessSum;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        access = new boolean[n];
        accessMinus = new boolean[n*2+1];
        accessSum = new boolean[n*2+1];
        cur = new ArrayList<>();

        handle(n, 0);
        return ans;

    }

    public void handle(int n, int line){
        if(line >= n) return;

        for(int row = 0 ; row < n ; row++){

            if(access[row] || accessMinus[row-line+n] || accessSum[row+line]) continue;

            access[row] = true;

            accessMinus[row-line+n] = true;
            accessSum[row+line] = true;
            cur.add(generateStr(n, row));

            if(cur.size() == n) {
                ans.add(new ArrayList<>(cur));
                access[row] = false;
                accessMinus[row-line+n] = false;
                accessSum[row+line] = false;
                cur.remove(cur.size() - 1);
                continue;
            }

            handle(n, line+1);

            access[row] = false;
            accessMinus[row-line+n] = false;
            accessSum[row+line] = false;
            cur.remove(cur.size() - 1);
        }
    }

    public String generateStr(int n, int idx){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n; i++){
            if(i == idx) sb.append('Q');
            else sb.append('.');
        }
        return sb.toString();
    }
}
