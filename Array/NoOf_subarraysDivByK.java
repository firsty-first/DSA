class Solution {
    public int subarraysDivByK(int[] nums, int k) {
      int n=nums.length;
  
        int j=0,c=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int pre[]=new int[n];
        int mod[]=new int [n];
pre[0]=nums[0];
mod[0]=(pre[0])%k;
      if (mod[0] < 0) {
                mod[0] += k; // Handle negative mods
            }
map.put(mod[0],map.getOrDefault(mod[0],0)+1);
if(mod[0]==0)
c=1;

  
        for(int i=1;i<n;i++)
        {
         pre[i]=pre[i-1]+nums[i];
         mod[i]=(pre[i])%k;
         if (mod[i] < 0) {
                mod[i] += k; // Handle negative mods
            }
         if(map.containsKey(mod[i]))
         {
          System.out.println(mod[i]);
          c=c+map.get(mod[i]);
          map.put(mod[i],map.get(mod[i])+1);
         }
         else
         map.put(mod[i],map.getOrDefault(mod[i],0)+1);
        }
        return c;
    }
}
