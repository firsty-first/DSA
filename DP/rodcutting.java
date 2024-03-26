

class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int dp[][]=new int [n][n+1];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        
        return f(n-1,n,price,dp);
    }
    static int f(int ind,int n,int price[],int [][]dp)
    {
        if(ind==0)
        {
          return n*price[0];
        }
        if(dp[ind][n]!=-1)
        return dp[ind][n];
        int not=f(ind-1,n,price,dp);
        int cut=Integer.MIN_VALUE;
        if(n-(ind+1)>=0)
        cut=price[ind]+f(ind,n-(ind+1),price,dp);
        return dp[ind][n]=Math.max(cut,not);
    }
}
