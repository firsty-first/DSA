
class Solution
{
	public int minOperations(String s1, String s2) 
	{ 
	    // Your code goes here
	     // code here
        
        int n=s1.length();
        int m=s2.length();
        
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(dp[i],0);
            
        }
        int mx=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
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
        int lenLcs=mx;
        int del=n-lenLcs;
        int insert=m-lenLcs;
        return del+insert;
    
	} 
}

