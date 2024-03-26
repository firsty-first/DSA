
class Solution
{
    public int longestPalinSubseq(String s1)
    {
        String s2=reverseString(s1);
        int n=s1.length();
    int dp[][]=new int[n+1][n+1];
    for(int i=0;i<=n;i++)
    Arrays.fill(dp[i],0);
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            if(s1.charAt(i-1)==s2.charAt(j-1)) // i-1 coz i is 1 based indexing
            dp[i][j]=1+dp[i-1][j-1];
            else
            dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        }
    }
    return dp[n][n];
    }
     public static String reverseString(String str) {
        // Create a StringBuilder object with the given string
        StringBuilder sb = new StringBuilder(str);
        
        // Use the reverse() method of StringBuilder to reverse the string
        sb.reverse();
        
        // Convert the StringBuilder back to a String and return it
        return sb.toString();
    }
}
