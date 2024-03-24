
// User function Template for Java
//this boils down to rech target but here target is sum of array/2 bcz if 2 parts of
//array are equal it must be sumof array /2 each 
class Solution{
   static boolean first=true;
    static int equalPartition(int N, int arr[])
    {
        // code here
         int dp[][]=new int[N][100001];
       for(int i=0;i<N;i++)
        Arrays.fill(dp[i],-1);
        int sum=0;
         for(int i:arr)
        sum+=i;
        if(sum%2==1)
        return 0;
       boolean ans= f(0,arr,sum/2,dp);
       if(ans==true)
       return 1;
       else
       return 0;
    }
     static boolean f(int ind,int arr[],int sum,int dp[][])
    {
        if(sum==0 && first==false)
        return true;
        first=false;
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
