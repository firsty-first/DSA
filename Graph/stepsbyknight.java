
class pair
{
    int row,col,level;
    pair(int row,int col,int level)
    {
        this.row=row;
        this.col=col;
        this.level=level;
    }
}
class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KPos[], int TPos[], int N)
    {
        // Code here
        PriorityQueue<pair> pq=new PriorityQueue<pair>((x,y)->x.level-y.level);
        int dist[][]=new int[N][N];
        TPos[0]=TPos[0]-1;
        TPos[1]=TPos[1]-1;
        KPos[0]=KPos[0]-1;
        KPos[1]=KPos[1]-1;
        for(int i=0;i<N;i++)
        Arrays.fill(dist[i],Integer.MAX_VALUE);
        pq.offer(new pair(KPos[0],KPos[1],0));
        dist[KPos[0]][KPos[1]]=0;
        int A[][]=new int[N][N];
        
        while(!pq.isEmpty())
        {
            pair p=pq.poll();
            int r=p.row;
            int c=p.col;
            int lvl=p.level;
            int delr[]={-2,-2,-1,-1,2,2,1,1};
            int delc[]={-1 ,1,-2, 2,1,-1,2,-2};
            for(int i=0;i<8;i++)
            {
                int nrow=r+delr[i];
                int ncol=c+delc[i];
                if(nrow>=0 && nrow<N && ncol>=0 && ncol<N)
                {
                    // if(nrow==TPos[0] && ncol==TPos[1])
                    // return lvl;
                    if(lvl+1<dist[nrow][ncol])
                    {
                        pq.offer(new pair(nrow,ncol,lvl+1));
                        dist[nrow][ncol]=lvl+1;
                    }
                }
            }
        }
            if(dist[TPos[0]][TPos[1]]==Integer.MAX_VALUE)
        return -1;
        else
        return dist[TPos[0]][TPos[1]];
            
        
        
    }
}
