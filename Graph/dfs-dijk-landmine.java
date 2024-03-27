class pair
{
    int row,col,weight;
    pair(int row, int col,int weight)
    {
        this.row=row;
        this.col=col;
        this.weight=weight;
    }
}

class Solution {
    public static Queue<pair> q=new LinkedList<>();
    public static int findShortestPath(int[][] mat) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        int delr[]={-1,0,1,0};
        int delc[]={0,-1,0,1};
               
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
          int[][] mat1 = new int[mat.length][];
        for (int i = 0; i < mat.length; i++) {
            mat1[i] = new int[mat[i].length];
            for (int j = 0; j < mat[i].length; j++) {
                mat1[i][j] = mat[i][j];
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                for(int k=0;k<4;k++)
                {
                    int nrow=i+delr[k];
                    int ncol=j+delc[k];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m )
                    mat1[nrow][ncol]=0;
                }
            }
        }
        
       int min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++)
        {
            if(mat1[i][0]==1)
          {
               q.offer(new pair(i,0,1));
        dist[i][0]=0;
              bfs(i,0,dist,mat1);
          }
          
        }
        
        for(int j=0;j<n;j++)
        min=Math.min(min,dist[j][m-1]);
        if(min==Integer.MAX_VALUE)
        return -1;
        return min;
    }
    static void bfs(int i,int j,int dist[][],int mat[][])
    {
        int n=mat.length;
        int m=mat[0].length;
         int delr[]={-1,0,1,0};
        int delc[]={0,-1,0,1};
 
       
        while(!q.isEmpty())
        {
            pair p=q.poll();
            int r=p.row;
            int c=p.col;
            int wt=p.weight;
            for(int k=0;k<4;k++)
            {
                int nrow=r+delr[k];
                    int ncol=c+delc[k];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol]==1)
                    {if(1+wt<dist[nrow][ncol])
                    {
                        dist[nrow][ncol]=1+wt;
                        q.offer(new pair(nrow,ncol,1+wt));
                        
                    }
                        
                    }
            }
        }
    }
    
}
