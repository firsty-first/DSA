//pair was not req as i am already using dist array 
class pair
{
    int edge,weight;
    pair(int edge,int weight)
    {
        this.edge=edge;
        this.weight=weight;
    }
}

class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        boolean vis[]=new boolean[n];
        Arrays.fill(vis,false);
        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(src,0));
        vis[src]=true;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
          adj.add(new ArrayList<>());
        }
          for(int i=0;i<m;i++)
        {
          adj.get(edges[i][0]).add(edges[i][1]);
           adj.get(edges[i][1]).add(edges[i][0]);
        }
        int t=0;
        while(!q.isEmpty())
        {
            t++;
           pair p=q.poll();
           int node=p.edge;
           int wt=p.weight;
          //  dist[node]=t;
            for(int it:adj.get(node))
            {
                if(dist[node]+1<dist[it])
                {
                    dist[it]=1+dist[node];
                    q.offer(new pair(it,wt+1));
                }
            }
           
        }
        for(int i=0;i<n;i++)
        if(dist[i]==Integer.MAX_VALUE)
        dist[i]=-1;
        return  dist;
        
    }
    
}
