
class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
       int dp[][]=new int[1001][10001];
       for(int i=0;i<1001;i++)
        Arrays.fill(dp[i],-1);
        return f(0,arr,sum,dp);
    }
    static boolean f(int ind,int arr[],int sum,int dp[][])
    {
        if(sum==0)
        return true;
        if(ind ==arr.length)
        return false;
        if(dp[ind][sum]!=-1)
        return dp[ind][sum]==1;
       boolean not=f(ind+1,arr,sum,dp);
        boolean pick=false;
        if(sum-arr[ind]>=0)
        pick=f(ind+1,arr,sum-arr[ind],dp);
        boolean ans=pick|not;
        if(ans==true)
        dp[ind][sum]=1;
        else
        dp[ind][sum]=0;
        return ans;
    }
}
