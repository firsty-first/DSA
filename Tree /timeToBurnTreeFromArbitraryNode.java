
class Solution
{
//basically a bfs traversal but ability to go up to parent as well just like graph
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        Queue<Node> q=new LinkedList<>();
      //  Arraylist<Node> vis=new ArrayList<>();
        HashMap<Node, Node> h=new HashMap<>();
        HashSet<Node> vis=new HashSet<>();
        q.offer(root);
        int total=0;
        Node tar=null;
        while(!q.isEmpty())
        {
           
            total++;
            Node n=q.poll();
             if(target==n.data)
            tar=n;
            if(n.left!=null)
           { h.put(n.left,n);
               q.offer(n.left);
           }
            if(n.right!=null)
           { h.put(n.right,n);
               q.offer(n.right);
           }
        }
        q.clear();
        q = new LinkedList<>();
        q.offer(tar);
        vis.add(tar);
        int lvl=0,fl=0;
        
         while(!q.isEmpty())
        {
            //lvl++;
            fl=0;
            int sz=q.size();
            for(int i =0;i<sz;i++)
            {
                
                Node n=q.poll();
            if(n.left!=null && !vis.contains(n.left))
           { vis.add(n.left);
           fl=1;
               q.offer(n.left);
           }
            if(n.right!=null && !vis.contains(n.right))
           { vis.add(n.right);
              fl=1;
               q.offer(n.right);
           } 
           if(h.containsKey(n) && !vis.contains(h.get(n)))
           {
               vis.add(h.get(n));
                  fl=1;
               q.offer(h.get(n));
           }
           
            }
            if(fl==1)
            lvl++;
           
        }
        
        return lvl;
    }
}
