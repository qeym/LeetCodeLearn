package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution994 {

    public static void main(String[] args) {
        int i = new Solution994().orangesRotting(new int[][]{{1, 2}});
        System.out.println(i);
    }

    public int orangesRotting(int[][] grid) {
        List<String> rottenOranges = new LinkedList<>();
        List<String> freshOranges = new LinkedList<>();

        int line = grid.length;
        int row = grid[0].length;

        for(int i = 0 ; i < line ; i++){
            for(int j = 0 ; j < row ; j++){
                if(grid[i][j] == 1){
                    freshOranges.add(i + "," + j);
                }
                if(grid[i][j] == 2){
                    rottenOranges.add(i + "," + j);
                }
            }
        }
        int ans = 0;
        boolean change = true;
        while (rottenOranges.size() > 0 && change){
            change = false;

            int rottenSize = rottenOranges.size();
            for(int i = 0 ; i < rottenSize ; i++){
                String cur = rottenOranges.get(i);
                String[] split = cur.split(",");

                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);

                if( x-1 >= 0){
                    String curPoint = (x-1) + "," + y;
                    if(freshOranges.contains(curPoint)){
                        freshOranges.remove(curPoint);
                        grid[x-1][y] = 2;
                        rottenOranges.add(curPoint);
                        change = true;
                    }
                }
                if( x+1 < line){
                    String curPoint = (x+1) + "," + y;
                    if(freshOranges.contains(curPoint)){
                        freshOranges.remove(curPoint);
                        grid[x+1][y] = 2;
                        rottenOranges.add(curPoint);
                        change = true;
                    }
                }
                if( y-1 >= 0){
                    String curPoint = x + "," + (y-1);
                    if(freshOranges.contains(curPoint)){
                        freshOranges.remove(curPoint);
                        grid[x][y-1] = 2;
                        rottenOranges.add(curPoint);
                        change = true;
                    }
                }
                if( y+1 < row){
                    String curPoint = x + "," + (y+1);
                    if(freshOranges.contains(curPoint)){
                        freshOranges.remove(curPoint);
                        grid[x][y+1] = 2;
                        rottenOranges.add(curPoint);
                        change = true;
                    }
                }

            }
            if(change) ans++;

        }
        if(freshOranges.size() > 0) return -1;
        return ans;

    }
}
