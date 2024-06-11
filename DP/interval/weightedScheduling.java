class pair
{
  int start,end,profit;
  pair(int start,int end,int profit)
  {
    this.start=start;
    this.end=end;
    this.profit=profit;
  }
}
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
           int  n=startTime.length;
             int totalProfit = 0;
        int lastEndTime = 0;
            pair []p=new pair[n];
            for(int i=0;i<n;i++)
            {
              p[i]=new pair(startTime[i],endTime[i],profit[i]);
            }
            Arrays.sort(p,(x,y)->x.start-y.start);
          int dp[]=new int[n+1];
          Arrays.fill(dp,-1);
            return f(0,p,dp);
    }
    int f(int i,pair p[],int dp[])
    {
        if(i==p.length)
        return 0;
        if(dp[i]!=-1)
        return dp[i];
        //not pick
        int q=f(i+1,p,dp);
        //pick
        int j=i+1;
         while(j<p.length)
         {
          if(p[i].end<=p[j].start)
          break;
          j++;
         }
        q=Math.max(q,p[i].profit+f(j,p,dp));
        return dp[i]=q;
    }
}
