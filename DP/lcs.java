class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int x=s1.length();
        int y=s2.length();
        int dp[][]=new int[x+1][y+1];
        for(int i=0;i<=x;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return lcsfind(s1,s2,x-1,y-1,dp);
    }
    static int lcsfind(String s1, String s2, int i,int j,int dp[][])
  {
    if(i<0 || j<0)
    return 0;
    if(dp[i][j]!=-1)
    return dp[i][j];
    
    if(s1.charAt(i)==s2.charAt(j)) 
                                       
    return dp[i][j]= 1+lcsfind(s1, s2, i-1, j-1,dp);
    else
    return dp[i][j]=Math.max(lcsfind(s1, s2, i-1, j,dp) ,lcsfind(s1, s2, i, j-1,dp));

  }
}
