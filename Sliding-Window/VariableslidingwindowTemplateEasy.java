class Solution {
    public long countSubarrays(int[] nums, int k) {
        int i=0,j=0;
        int n=nums.length;
        int mx=0,countMax=0;
        long c=0;
  
        for(int p:nums)
        mx=Math.max(mx,p);

        while(i<n && j<n)
        {
           if(nums[j]==mx)
           countMax++;
           while(countMax>=k)
           {
            c=c+(n-j);
                if(mx==nums[i])
                countMax--;
                i++;
           }
           j++;

        }
        return c;
    }
}
