//dijkstra on grid
//we do not need priority Queue here as edge weight is 1 for all so all the node aty same level will have same weigth hence no need of ssorting thm on cost/ path length/ distance 
    //thus savingO(logm)
class pair
{
    int row,col,distance;
    pair(int row,int col,int distance)
    {
        this.row=row;
        this.col=col;
        this.distance=distance;
    }
}
// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if(source[0]==destination[0] && source[1]==destination[1])
        return 0;
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<pair> pq=new PriorityQueue<pair>((x,y)->x.distance-y.distance);
        pq.offer(new pair(source[0],source[1],0));
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++)
        Arrays.fill(dist[i],Integer.MAX_VALUE);
        while(!pq.isEmpty()){
            pair p=pq.poll();
            int r=p.row;
            int c=p.col;
            int d=p.distance;
            int delr[]={-1,0,1,0};
            int delc[]={0,-1,0,1};
            for(int i=0;i<4;i++)
            {
                int nrow=r+delr[i];
                int ncol=c+delc[i];
                if(nrow>=0 && nrow<n && ncol>=0  && ncol<m && grid[nrow][ncol]==1)
                
                {
                    if(1+d<dist[nrow][ncol])
                    {
                        dist[nrow][ncol]=1+d;
                        pq.offer(new pair(nrow, ncol, dist[nrow][ncol]));
                    }
                }
            }
            
        }
        int ans=dist[destination[0]][destination[1]];
        if(ans==Integer.MAX_VALUE)
        return -1;
        else
        return ans;
        
    }
}
