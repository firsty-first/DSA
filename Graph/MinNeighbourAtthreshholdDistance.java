

// User function Template for Java
class pair
{
    int node,weight;
    pair(int node,int weight)
    {
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
          //code here
          ArrayList<ArrayList<pair>> adj=new ArrayList<>();
          for(int i=0;i<=2*n;i++)
          adj.add(new ArrayList<>());
          HashSet<Integer> h=new HashSet<>();
          for(int i=0;i<m;i++)
          {
            adj.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
           adj.get(edges[i][1]).add(new pair(edges[i][0],edges[i][2]));
            h.add(edges[i][0]);
             h.add(edges[i][1]);
              
          }
          
      int min=Integer.MAX_VALUE;   
      int res=0;
     
for(int i=0;i<n;i++)
{
    
    
    
    //int reachable=bfs(i,n,m,adj,distanceThreshold);
    int reachable=dijkstra(i,n,adj,distanceThreshold);
   //System.out.println(i+"-->"+reachable);
  if(reachable<=min )
  {
      min=reachable;
      res=i;
  }
 
}
return res;
          
      }
      static int dijkstra(int start, int n, ArrayList<ArrayList<pair>> adj,int thresh) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<pair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.weight));
        pq.offer(new pair(start, 0));

        while (!pq.isEmpty()) {
            pair p = pq.poll();
            int node = p.node;
            int d = p.weight;

            for (pair it : adj.get(node)) {
                int currNode = it.node;
                int wt = it.weight;

                if (d + wt < dist[currNode]) {
                    dist[currNode] = d + wt;
                    pq.offer(new pair(currNode, dist[currNode]));
                }
            }
        }

        // Additional logic here if needed
        int c=0;
for(int i:dist)
      { 
          //System.out.print(i+", ");
         if(i<=thresh && i!=0 )
          { 
             
        c++;
          }
      }
        return c; // or whatever you want to return
    }
     static int bfs(int start,int n,int m, ArrayList<ArrayList<pair>> adj,int thresh)
      {
          int dist[]=new int[n];
          Arrays.fill(dist,999999);
          dist[start]=0;
          
                                      
PriorityQueue<pair> q=new PriorityQueue<pair>((x,y)->x.weight-y.weight);
//Queue<pair> q=new LinkedList<>();
    q.offer(new pair(start,0));
    int c=0;
    while(!q.isEmpty())
    {
        pair p=q.poll();
        int node=p.node;
        int d=p.weight;
        
        for(pair it: adj.get(node))
        {
            
            int currNode=it.node;
            int wt=it.weight;
            
            if(wt+d<dist[currNode] )
            {

                dist[node]=wt+d;
                q.offer(new pair(currNode,wt+d));
            }
        }
    }
    for(int i:dist)
      { 
          System.out.print(i+", ");
        //  if(i<=thresh )
        //   { 
        //       //System.out.println(start+"="+i+" ");
        // c++;
        //   }
      }
      System.out.println();
      System.out.println("--------------------");
      // System.out.println(start+"node ---> neighbour count:"+c);
   return c;
      }
}
