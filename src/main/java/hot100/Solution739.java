package hot100;


import java.util.Stack;

public class Solution739 {

    public static void main(String[] args) {
        int[] input = new int[]{73,74,75,71,69,72,76,73};
        new Solution739().dailyTemperatures(input);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i = 0 ; i < temperatures.length ; i++){
            int cur = temperatures[i];
            while(!stack.isEmpty() && stack.peek()[1] < cur){

                int[] popAry = stack.pop();
                ans[popAry[0]] = i - popAry[0];

            }

            int[] pushAry = new int[]{i, cur};
            stack.push(pushAry);
        }
        return ans;
    }
}
