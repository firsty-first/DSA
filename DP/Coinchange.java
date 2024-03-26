
class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long dp[][]=new long[N+5][sum+5];
        for(int i=0;i<N+1;i++)
        Arrays.fill(dp[i],-1);
        
        return f(N-1,sum,coins,dp);
        
    }
    static long f(int ind,int sum,int a[],long dp[][])
    {if(ind<0)
    return 0; 
    // bcz i have no option to reach target exact sum 
    
        // did not retrun instantly when found target as it would miss many more 
                        //combination appearing after
                        
    //   if(sum==0)  //as i thought instant retrurn is also correct 
    //   return 1;
        if(ind==0) 
        {
            if(sum%a[0]==0)
            return 1;
            if(sum==0)
            return 1;
        }
        
        if(dp[ind][sum]!=-1)
        return dp[ind][sum];
        
        long not=f(ind-1,sum,a,dp);
        long take=0;
        if(sum-a[ind]>=0)
        take=f(ind,sum-a[ind],a,dp);
        return dp[ind][sum]=take+not;
    }
}
