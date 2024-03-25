
class Solution {
    
	
    public static int countPartitions(int n, int d, int[] num) {
        // code here
       
        int sum=0;
        for(int i:num)
        sum=sum+i;
      
        int tar=(sum-d)/2;
        if(tar<0)
        return 0;
          if((sum-d)%2==1)
        return 0;
         
      int dp[][]=new int[num.length+1][tar+1];
     
        for(int i=0;i<num.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
       return  f(0, tar, num,dp);
    }
    static int f(int ind,int tar,int a[],int dp[][])
    {
         int n=a.length;
        int mod=1000000007;
       // System.out.println(tar);
        
     if (ind == n - 1) {

            if (tar == 0 && a[n - 1] == 0) return 2;

            if (tar == 0 || a[n - 1] == tar) return 1;

            else return 0;

        }
            if(dp[ind][tar]!=-1)
            return dp[ind][tar];

         int take=0;
        if(tar-a[ind]>=0)
        take=f(ind+1,tar-a[ind],a,dp);
        int not=f(ind+1,tar,a,dp);
        
        return dp[ind][tar]=(take+not)%mod;
    }
}

