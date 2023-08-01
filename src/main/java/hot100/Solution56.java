package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution56 {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1,4}, {0,2},{3,5}};
        new Solution56().merge(input);
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

        List<int[]> ansList = new ArrayList<>();
        int index = 0 ;
        while(index < intervals.length){
            int leftIndex = index;
            int[] ansAry = new int[]{intervals[leftIndex][0], intervals[leftIndex][1]};
            index++;
            while(index < intervals.length){
                if(intervals[index][0] <= ansAry[1]){
                    ansAry[1] = Math.max(ansAry[1], intervals[index][1]);
                    index++;
                }else{
                    break;
                }
            }
            ansList.add(ansAry);
        }
        return ansList.toArray(new int[ansList.size()][2]);
    }
}
