class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int ans[]=new int[quiet.length];
        int n=quiet.length;
        int indeg[]=new int[quiet.length];
        for(int i=0;i<n;i++)
        {
          adj.add(new ArrayList<>());
        }
        for(int r[]:richer)
        {
          adj.get(r[0]).add(r[1]);
          indeg[r[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++)
     {  
        ans[i]=i;
         if(indeg[i]==0)
        q.offer(i);}
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty())
        {
          int node=q.poll();
            topo.add(node);
            for(int it:adj.get(node))
            {
              if(quiet[node]<quiet[it])
              {
            
                quiet[it]=quiet[node];
                ans[it]=ans[node];
    System.out.println(ans[it]);
              }
              
              indeg[it]--;
              if(indeg[it]==0)
              q.offer(it);

            }
        }
      
        // for(int i:topo)
        // {
        //   System.out.println(i);
            
        // }
        return ans;
    }
}
