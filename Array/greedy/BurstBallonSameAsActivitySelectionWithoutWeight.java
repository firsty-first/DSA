
class pair
{
  long start,end;
  pair(long start,long end)
  {
    this.start=start;
    this.end=end;
  }
}
class Solution {
    public int findMinArrowShots(int[][] points) {
      
        int n=points.length;
      PriorityQueue<pair> pq=new PriorityQueue<>((x,y)->
      {
        if(Long.compare(x.end,y.end)!=0)
       return  Long.compare(x.end, y.end);
       else
       return Long.compare(x.start,y.start);
    });
      for(int i=0;i<n;i++)
      {
        pq.offer(new pair(points[i][0],points[i][1]));
      }
    // while(!pq.isEmpty())
    // {
    //   System.out.println(pq.peek().start+".."+pq.peek().end);
    //   pq.poll();
    // }

  int c=0;
      while(!pq.isEmpty())
      {
        c++;
        pair p=pq.poll();
      long st=p.start;


        long end=p.end;
       
        while(!pq.isEmpty() && pq.peek().start<=end)
        {
           
          pq.poll();
          
        }
        
      }
      return c;
    }
}
