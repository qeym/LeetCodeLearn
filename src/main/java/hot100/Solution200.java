package hot100;

public class Solution200 {

    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'1','1','0','0','0'},
  {'1','1','0','0','0'},
  {'0','0','1','0','0'},
  {'0','0','0','1','1'}
};
        int i = new Solution200().numIslands(input);
        System.out.println(i);
    }

    public int numIslands(char[][] grid) {
        int line = grid.length, row = grid[0].length;
        int ans = 0;
        for(int i = 0 ; i < line ; i++){
            for(int j = 0 ; j < row ; j++){
                if(grid[i][j] == '1') {
                    handle(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;

    }

    public void handle(char[][] grid, int x, int y){
        int line = grid.length, row = grid[0].length;
        if(x < 0 || x >= line || y < 0|| y >= row || grid[x][y] == '2') return;


        if(grid[x][y] == '1') {
            grid[x][y] = '2';
            handle(grid, x-1,y);
            handle(grid, x+1,y);
            handle(grid, x,y-1);
            handle(grid, x,y+1);
        }
        

    }

}
