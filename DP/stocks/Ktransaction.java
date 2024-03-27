class Solution {
    static int maxProfit(int k, int n, int a[]) {
        // code here
        int dp[][][]=new int[n+1][3][k+1];
        for(int i=0;i<=n;i++)
        {
            for(int buy=0;buy<=2;buy++)
            {
                Arrays.fill(dp[i][buy],0);
            }
        }

        for(int i=n-1;i>=0;i--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                for(int trans =1;trans<=k;trans++)
                {
                    if(buy==1)
        {
           dp[i][buy][trans]=Math.max(-a[i]+dp[i+1][0][trans],dp[i+1][1][trans]);
        }
        else
        dp[i][buy][trans]=Math.max(a[i]+dp[i+1][1][trans-1],dp[i+1][0][trans]);
      
                }
            }
        }
        return dp[0][1][k];
    }
}

