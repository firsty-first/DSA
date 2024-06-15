class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int maxEvents(int[][] events) {
        int n=events.length;
        Interval p[]=new Interval[n];
        for(int i=0;i<n;i++)
        {
          p[i]=new Interval(events[i][0],events[i][1]);
        }
        Arrays.sort(p,(x,y)->{
          if(y.start==x.start)
          return x.end-y.end;
          else
          return x.start-y.start;
        });
        boolean vis[]=new boolean[n];

        int t=0,c=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int day=1;day<=100000;day++)
        {
          while(t<n && p[t].start<=day)
          {
             System.out.println(p[t].start+"->"+p[t].end);
            pq.offer(p[t].end);
            t++;
           
          }
          while(!pq.isEmpty())
          {
           if(pq.peek()>=day){ System.out.println(pq.peek());
            pq.poll();
            c++;
            break;
            }
            else
           System.out.println("Ejected"+ pq.poll());

          }
        }
return c;
       
    }
}
