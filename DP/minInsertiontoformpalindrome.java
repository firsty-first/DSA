class Solution{
    static int countMin(String s1)
    {
        // code here
        String s2="";
        int n=s1.length();
        for(int i=n-1;i>=0;i--)
        {
            s2=s2+s1.charAt(i);
        }
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(dp[i],0);
            
        }
        int mx=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                    mx=Math.max(mx,dp[i][j]);
                }
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return n-mx;
    }
    
}
