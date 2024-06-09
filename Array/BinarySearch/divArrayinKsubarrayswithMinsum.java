class Solution {
    public int splitArray(int[] nums, int k) {
        int mx=0,s=0;
        for(int i:nums)
        {
          mx=Math.max(mx,i);
          s=s+i;
        }
        int l=mx,h=s;
        int ans=s;
         System.out.println(l+","+h);
        while(l<=h)
        {
          int mid=(l+h)/2;
          System.out.println(mid);
          if(f(nums,k,mid)==true)
          {
              ans=Math.min(ans,mid);
              h=mid-1;
          }
          else
          l=mid+1;
        }
        return ans;
    }
   boolean f(int a[],int k,int lim)
    {
int s=0,c=0;
      int n=a.length;
      for(int i=0;i<n;)
      {
        if(a[i]+s<=lim) // this condition must always be true for s=0 and any a[i] other wise TLE
        //therefeore it befomes important to set range of binary search from max(a[i]) and not anything else to avoid TLE
        {
          s=s+a[i];
          i++;
        }
        else
        {
          c++;
          s=0;
        }
      }
      if(s!=0 && s<=lim)
      c++;
      if(c<=k)
      return true;
      return false;
    }
}
