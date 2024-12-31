//Last Git Push for the year 2024 
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        
        for(int i = days.length - 1; i >= 0; i--)
        {
            dp[i] = 9999999;
            int[] pass = {1, 7, 30};

            for(int j = 0; j < 3; j++)
            {
                int k = i;
                while(k < days.length && days[k] < days[i] + pass[j])
                    k++;
                dp[i] = Math.min(dp[i], costs[j] + dp[k]);
            }
        }
        
        return dp[0];
    }
}
