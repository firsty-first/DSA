# DSA
## lambda Streams
### PriorityQueue<pair> pq=new PriorityQueue<pair>((x,y)->x.distance-y.distance);
x and y are automatically of type pair and above implementation sorts priority queue in ascending order of distance 
## custom comparator easy using lambda expression than overriding comparator function
  PriorityQueue<pair> pq=new PriorityQueue<>((x1,y1)->{
           if(x1.diff!=y1.diff)
           return x1.diff-y1.diff;
         else
      return y1.num-x1.num;
           });
## DS
### Treemap orders itself in ascending order on keys , useful in vertical order traversal
