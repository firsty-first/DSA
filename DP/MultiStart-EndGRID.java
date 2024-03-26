//loop through all the column for start and max aof all to get the ans
class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int dp[][]=new int[N+1][Matrix[0].length+1];
        for(int i=0;i<=N;i++)
        Arrays.fill(dp[i],-1);
        int ans=0;
        for(int i=0;i<Matrix[0].length;i++)
        {
            ans=Math.max(ans,f(N-1,i,Matrix,dp));
        }
        return ans;
    }
    static int f(int i,int j,int a[][],int dp[][])
    {
        
        if(i<0)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        int d1=Integer.MIN_VALUE,d2=Integer.MIN_VALUE;
        int up=a[i][j]+f(i-1,j,a,dp);
        if(j-1>=0)
       d1=a[i][j]+f(i-1,j-1,a,dp);
        if(j+1<a[0].length)
        d2=a[i][j]+f(i-1,j+1,a,dp);
        return dp[i][j]=Math.max(Math.max(up,d1),d2);
    }
}
