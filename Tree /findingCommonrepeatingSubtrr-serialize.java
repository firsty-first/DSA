
class Solution {
        HashMap<String,Integer > map=new HashMap<>();
        List<Node> ans=new ArrayList<>();
    public List<Node> printAllDups(Node root) {
        // code here
    
        f(root);
        return ans;
        
    }
   String  f(Node n)
    {
        if(n==null)
        {
            return "";
        }
        String l=f(n.left);
        String r=f(n.right);
     String s=n.data+","+l+","+r;
     map.put(s,map.getOrDefault(s,0)+1);
     if(map.get(s)==2)
     ans.add(n);
     return s;
    }
}
