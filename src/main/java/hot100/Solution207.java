package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        grid = new List[numCourses];
        access = new int[numCourses];
        vaild = true;

        for(int i = 0 ; i < prerequisites.length ; i++){
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];

            if(grid[pre] == null){
                List<Integer> newList = new ArrayList<>();
                newList.add(cur);
                grid[pre] = newList;
            }else{
                grid[pre].add(cur);
            }
        }

        for(int i = 0 ; i < numCourses ; i++){
            if(access[i] == 0){
                dfs(i);
            }
        }

        return vaild;
    }
    int[] access;
    List<Integer>[] grid;
    boolean vaild;
    public void dfs(int cur){
        if(!vaild) return ;
        access[cur] = 1;
        if(grid[cur] == null){
            access[cur] = 2;
            return;
        }

        for(int temp: grid[cur]){
            if(access[temp] == 0){
                dfs(temp);
            }else if(access[temp] == 1){
                vaild = false;
                return;
            }
        }
        access[cur] = 2;
    }
}
