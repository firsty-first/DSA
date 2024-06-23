class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int ans=0,i=0,n=nums.length,left=0;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for( i=0;i<n;i++)
        {
          map.put(nums[i],map.getOrDefault(nums[i],0)+1);
          while(map.lastKey()-map.firstKey()>limit)
          {
            map.put(nums[left],map.get(nums[left])-1);
            if(map.get(nums[left])==0)
            map.remove(nums[left]);
            left++;
          }
          ans=Math.max(ans,i-left+1);
        }
        return ans;
    }
}
