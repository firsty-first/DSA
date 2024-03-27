
class Solution {
    public int editDistance(String s, String t) {
        // Code here
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n+1;i++)
        Arrays.fill(dp[i],-1);
        return f(n-1,m-1,s,t,dp);
    }
    static int f(int i,int j,String s, String t,int dp[][])
    {
      
        if(i<0)
        return j+1;
        if(j<0)
        return i+1;
          if(dp[i][j]!=-1)
        return dp[i][j];
        if(s.charAt(i)==t.charAt(j))
        return dp[i][j]=f(i-1,j-1,s,t,dp);
      //if do not match then i willl try all the way that is insert delete replace 
      //these are carried by means of index only no actual manipulation of string
      //we never actually modify strings in dp problem 
      // carry operations with the meanas of index only 
      // for example to demonstrate deletion in s1 we will insert char at t[j]  so that it matches , and move pointer of s1 only 
      
        int del=1+f(i-1,j,s,t,dp);
        int insert=1+f(i,j-1,s,t,dp);
        int repl=1+f(i-1,j-1,s,t,dp);
        return dp[i][j]=Math.min(del,Math.min(insert,repl));
    }
}
