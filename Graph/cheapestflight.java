
class pair 
{
    int node, stops,distance;
    pair(int node,int distance) //for adj
    {
        this.node=node;
       this.distance=distance;
    }
    //for queue
    pair(int node,int stops,int distance) // i won't create another model for adj and queue
    {
        this.node=node;
        this.stops=stops;
        this.distance=distance;
    }
    
}
class Solution {
    
    public int CheapestFLight(int ncity,int flights[][],int src,int dst,int k) {
        // Code here
       Queue<pair> q=new LinkedList<>();
       int n=flights.length;
       //int m=flights[0].length;
       ArrayList<ArrayList<pair>> adj=new ArrayList<>();
       for(int i=0;i<ncity;i++)
       {
          adj.add(new ArrayList<>());
       }
        for(int i=0;i<n;i++)
       {
          adj.get(flights[i][0]).add(new pair(flights[i][1],flights[i][2]));
       }
       int dist[]=new int[ncity+1];
       Arrays.fill(dist,Integer.MAX_VALUE);
       q.offer(new pair(src,0,0)); //node stops distance
       dist[src]=0;
       while(!q.isEmpty())
       {
           pair p=q.poll();
           int node=p.node;
           int stop=p.stops; //stops
           int dis=p.distance;
           if(stop>k)
               continue;
           for(pair it : adj.get(node))
           {
               int newnode=it.node;
               int edw=it.distance;// weight of vertex 
               if(dis+edw< dist[newnode] && stop<=k)
               {
                   q.offer(new pair(newnode,stop+1,dis+edw));
                   dist[newnode]=dis+edw;
               }
           }
       }
       
       int ans=dist[dst];
       if(ans==Integer.MAX_VALUE)
       return -1;
       else
       return ans;
    }
}
