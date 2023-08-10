package hot100;

public class Solution79 {
    public static void main(String[] args) {
        char[][] borad = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        boolean exist = new Solution79().exist(borad, word);
        System.out.println(exist);
    }

    int[][] access;
    boolean ans;

    public boolean exist(char[][] board, String word) {
        int line = board.length;
        int row = board[0].length;

        if(word.length() > line * row) return false;

        access = new int[line][row];
        handle(board, word, 0 , 0, 0);
        return ans;
    }

    public void handle(char[][] board, String word, int x, int y, int strIdx){
        int line = board.length;
        int row = board[0].length;
        if(ans || x < 0 || x >= line || y < 0 || y >= row ||
                access[x][y] == 1 || (access[x][y] == 2 && strIdx == 0)) return;


        if(board[x][y] == word.charAt(strIdx)) {
            if(strIdx == word.length() - 1){
                ans = true;
                return;
            }
            int temp = access[x][y];
            access[x][y] = 1;
            handle(board, word, x-1,y,strIdx + 1);
            handle(board, word, x+1,y,strIdx + 1);
            handle(board, word, x,y-1,strIdx + 1);
            handle(board, word, x,y+1,strIdx + 1);
            access[x][y] = temp;
        }

        if(strIdx == 0){
            access[x][y] = 2;
            handle(board, word, x+1, y, strIdx);
            handle(board, word, x, y+1, strIdx);
        }
    }
}
