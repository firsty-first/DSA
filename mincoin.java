
class Solution
{
    public int MinCoin(int[] nums, int amount)
    {
        // Code here
        int dp[][]=new int[nums.length+4][amount+4];
        for(int i=0;i<nums.length;i++)
        Arrays.fill(dp[i],-1);
        int ans=f(0,amount,nums,dp);
        if(ans==(int)1e9)
        return -1;
        return ans;
        
    }
    static int f(int ind,int t,int nums[],int dp[][])
    {
        if(ind==nums.length-1)
        {
            if(t%nums[ind]==0)
            {
               return t/ nums[ind];
            }
            else
            return (int)1e9;
        }
        if(dp[ind][t]!=-1)
        return dp[ind][t];
        
        int not=0+f( ind+1,t,nums,dp);
        int take=Integer.MAX_VALUE;
        if(t-nums[ind]>=0)
        take=1+f(ind,t-nums[ind],nums,dp);
        return dp[ind][t]=Math.min(take,not);
    }
}
