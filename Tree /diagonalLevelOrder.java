class Tree {
    public static ArrayList <Integer> diagonalSum(Node root) 
    {
        
        ArrayList <Integer> ans=new ArrayList <Integer>();
        
        Queue<Node> q=new LinkedList<>();
       
        q.offer(root);
        int s=0;
            
        while(!q.isEmpty())
        {
            //ArrayList <Integer> list=new ArrayList <Integer>();
           
            int size = q.size();
            int sum = 0; // Reset sum for each diagonal
            
            // Traverse nodes in current diagonal
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                while (node != null) {
                    sum += node.data; // Accumulate sum for current diagonal
                    if (node.left != null) q.offer(node.left);
                    node = node.right;
                }
            }
        
           ans.add(sum);
         
           
            }
             
            
        
        return ans;
        
    }
}
