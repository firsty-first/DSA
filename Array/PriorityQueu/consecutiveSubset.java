class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
      if(nums.length%k!=0)
      return false;
      boolean vis[]=new boolean[nums.length];
PriorityQueue<Integer> pq=new PriorityQueue<>();
int t=01;
        for(int i=0;i<nums.length;i++)
        {
          
         pq.offer(nums[i]);
        }
    
        while(!pq.isEmpty())
        {
          int x=pq.poll();
          for(int i=1;i<k;i++)
          {
              if(pq.remove(i+x)==false)
              return false;
              
          }
        }
        return true;
    }
}
