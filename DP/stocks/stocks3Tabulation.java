
class Solution {
    
    public int maxProfit(int n,int[] prices) {
        
        
        int dp[][][]=new int [n+1][3][3];
        for (int i = 0; i <= n; i++) {
    for (int j = 0; j < 3; j++) {
        Arrays.fill(dp[i][j], 0);
    }}
    // no need to fill base cases with 0 as whole dp[][][] is filled with 0
        int trans=2;
        for(int i=n-1;i>=0;i--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                for(trans=1;trans<=2;trans++)
                {
                    if(buy==1)
                    dp[i][buy][trans]=Math.max(-prices[i]+dp[i+1][0][trans],0+dp[i+1][1][trans]);
                    else
                    dp[i][buy][trans]=Math.max(prices[i]+dp[i+1][1][trans-1],0+dp[i+1][0][trans]);
                 
                }
            }
        }
        return dp[0][1][2];
      //  return f(0,1,prices,dp,trans);
    }
    
    static int f(int i,int buy,int a[],int dp[][][],int trans)
    {
        if(trans==0)
        return 0;
        
        if(i==a.length)
        return 0;
        int pr=0;
        if(dp[i][buy][trans]!=-1)
        return dp[i][buy][trans];
        if(buy==1)
            {pr=Math.max(-a[i]+f(i+1,0,a,dp,trans),f(i+1,1,a,dp,trans));
            
          
            }
            else
          {  pr=Math.max(a[i]+f(i+1,1,a,dp,trans-1),f(i+1,0,a,dp,trans));
          
          }
            return dp[i][buy][trans]=pr;
    }
    
}
