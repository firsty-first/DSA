class Solution{
    static int min=0;
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
        min=0;
        
       TreeMap<Integer,Integer> ans=new TreeMap<>();
        ArrayList <Integer> l=new ArrayList <Integer>();
      dfs(root,0,ans);
       
        
        
        for (Map.Entry<Integer, Integer> entry : ans.entrySet()) {
            Integer key = entry.getKey();
            
            Integer value = entry.getValue();
            l.add(key+Math.abs(min),value);
        }
         
       return l;
    }
    static void dfs(Node n,int k, TreeMap<Integer,Integer> ans)
    {
      if(n==null)
        return ;
        min=Math.min(min,k);
       
        dfs(n.left,k-1,ans);
      
        dfs(n.right,k+1,ans);
         ans.put(k,ans.getOrDefault(k,0)+n.data);
          
        
    }
   
}
