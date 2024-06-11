class pair
{
  int start,end;
  pair(int st,int end)
  {
    this.start=st;
    this.end=end;
  }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
      int n=intervals.length;
        pair p[]=new pair[n];
        for(int i=0;i<n;i++)
        {
p[i]=new pair(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(p,(x,y)->{
          if(x.start!=y.start)
          return x.start-y.start;
          else
          return x.end-y.end;
        });
        int end=p[0].end,c=0;
        for(int i=1;i<n;i++)
        {
          if(p[i].start<end)
          {
            if(p[i].end<end)
            {
                      end=p[i].end;
                      c++;
            }
            else

            c++;
            
          }
          else
          end=Math.max(end,p[i].end);
      
        }
        return c;
    }
}
