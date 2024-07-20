class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
int l=str1.length();
int m=str2.length();
        int dp[][]=new int[l+1][m+1];
      for(int i=0;i<l;i++)
      dp[i][0]=0;
  for(int i=0;i<m;i++)
      dp[0][i]=0;

        // int len=f(l-1,m-1,str1,str2,dp); this does the work but for retriving string it becoms a little tedious 
        //going with tabulation
        for(int i=1;i<=l;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];

                }
                else
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
       // int ans=str1.length()+str2.length()-len;

    // Build the shortest common supersequence from the DP table
    // for(int r[]:dp)
    // {
    //     for(int i:r)
    //     System.out.print(i+",");
    //         System.out.println();

    // }
        StringBuilder sb = new StringBuilder();
        int i = l, j = m;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }

        // Append remaining characters of str1 or str2
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        // Reverse the string since we constructed it backwards
        return sb.reverse().toString();
    }
    
    int f(int i,int j,String s,String t,int dp[][])
    {
        if(i==0 || j==0)
        {
      if( s.charAt(i)==t.charAt(0))
      return 1;
      else
      return 0;
        }
if(dp[i][j]!=-1)
return dp[i][j];
        int p=0,q=0;
        if(s.charAt(i)==t.charAt(j))
        p=1+f(i-1,j-1,s,t,dp);
        else
        q=Math.max(f(i-1,j,s,t,dp),f(i,j-1,s,t,dp));
        return dp[i][j]=p+q;
    }
}
