class pair
{
  int profit,capital;
  pair(int profit,int capital)
  {
    this.profit=profit;
    this.capital=capital;
  }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
      int n=profits.length;
        pair p[]=new pair[n];
        for(int i=0;i<n;i++)
        p[i]=new pair(profits[i],capital[i]);
        Arrays.sort(p,(x,y)->{
          if(x.capital!=y.capital)
          return x.capital-y.capital;
          else
          return x.profit-y.capital;
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->y-x);
        int i=0;
        while(k-- >0)
        {
     while(i<n && p[i].capital<=w)
     {
      pq.offer(p[i].profit);
      i++;
     }
     if(pq.isEmpty())
     break;
     else
   {  // System.out.println(pq.peek());
     w=w+pq.poll();
    }
        }
        return w;
    }
    
}
