
class pair
{
    int row,col,effort;
    pair(int row,int col,int effort)
    {
        this.row=row;
        this.col=col;
        this.effort=effort;
    }
}
class Solution {
    
    int MinimumEffort(int grid[][]) {
        int n=grid.length;
        int m=grid[0].length;
        int source[]={0,0};
        int destination[]={n-1,m-1};
       if(source[0]==destination[0] && source[1]==destination[1])
        return 0;
      
        PriorityQueue<pair> pq=new PriorityQueue<pair>((x,y)->x.effort-y.effort);
        pq.offer(new pair(source[0],source[1],0));
        int dist[][]=new int[n][m];
        int ans=0;
        for(int i=0;i<n;i++)
        Arrays.fill(dist[i],Integer.MAX_VALUE);
        while(!pq.isEmpty()){
            pair p=pq.poll();
            int r=p.row;
            int c=p.col;
            int diff=p.effort;
            if(r == n-1 && c == m-1) return diff; 
            int delr[]={1,0,-1,0};
            int delc[]={0,1,0,-1};
            for(int i=0;i<4;i++)
            {
                int nrow=r+delr[i];
                int ncol=c+delc[i];
               
                if(nrow>=0 && nrow<n && ncol>=0  && ncol<m )
                
                {
                    
                int neweffort=Math.max(Math.abs(grid[r][c]-grid[nrow][ncol]),diff);
                    if(neweffort<dist[nrow][ncol])
                    {
                        dist[nrow][ncol]=neweffort;
                        pq.offer(new pair(nrow, ncol,neweffort));
                        
                    }
                   
                }
            }
        }
       ans=dist[destination[0]][destination[1]];
       return dist[n-1][m-1];
        
    }
}
