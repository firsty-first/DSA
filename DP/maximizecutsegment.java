class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int dp[]=new int[n+1];
       Arrays.fill(dp,-1);
       int ans=f(n,x,y,z,dp);
       for(int i:dp)
       System.out.println(i);
       if(ans<=0)
       return 0;
       else
       return ans;
    }
    static int f(int n,int x,int y,int z,int dp[])
    {
        if(n==0)
        return 0;
        if(n<0)
        return Integer.MIN_VALUE;
        if(dp[n]!=-1)
        return dp[n];
        int p=1+f(n-x,x,y,z,dp);
         int q=1+f(n-y,x,y,z,dp);
          int r=1+f(n-z,x,y,z,dp);
          return dp[n]=Math.max(Math.max(p,q),r);
    }
}
