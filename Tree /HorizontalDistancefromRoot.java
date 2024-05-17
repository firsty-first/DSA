class Pair {
        Node node;
        int hd;
        
        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList <Integer> ans=new ArrayList <Integer>();
        ArrayList <Integer> l=new ArrayList <Integer>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
          Map<Integer, Integer> map = new TreeMap<>();
        while(!q.isEmpty())
        {
            int sz=q.size();
            for(int i=0;i<sz;i++)
            {
                Pair p=q.poll();
                Node n=p.node;
                int hd=p.hd;
                map.put(hd,n.data);
             
                if(n.left!=null)
                q.offer(new Pair(n.left,hd-1));
                if(n.right!=null)
                q.offer(new Pair(n.right,hd+1));
                
                
            }}
                 for (int value : map.values()) {
            ans.add(value);
        
            }
         
        
        return ans;
    }
}
