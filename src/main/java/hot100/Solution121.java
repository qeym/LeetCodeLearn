package hot100;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int buyPrice = Integer.MAX_VALUE;

        for(int price: prices){
            if(price < buyPrice){
                buyPrice = price;
            }else{
                if(price - buyPrice > ans){
                    ans = price - buyPrice;
                }
            }

        }
        return ans;
    }
}
