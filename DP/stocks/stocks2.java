
class Solution {
    public static int stockBuyAndSell(int n, int[] prices) {
        // code here
     int dp[][]=new int[n+1][2];
        for(int i=0;i<=n;i++)
     
        Arrays.fill(dp[i],- 1);
     int ans= f(0, 1, prices,dp);
   
     return ans;
    }

    static int f(int i,int buy,int a[],int dp[][])
    {
        if(i==a.length)
        return 0;
      
        if(dp[i][buy]!=-1)
        return dp[i][buy];
        int prof=0;
        if(buy==1)
        {
            prof=Math.max(-a[i]+f(i+1,0,a,dp),0+f(i+1,1,a,dp));
        }
        else
        {
            prof=Math.max(a[i]+f(i+1,1,a,dp),0+f(i+1,0,a,dp));
        }
        return dp[i][buy]= prof;
    }
}
