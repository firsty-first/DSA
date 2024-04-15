
class Solution {
    static boolean f;
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        f=true;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> l=new ArrayList<Integer> ();
        f(root,ans,l);
        return ans;
    }
   static void f(Node n,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> l)
    {
        if(n==null)
        {
           
            return;
        }
        l.add(n.data);
        if(n.left==null && n.right==null)
        ans.add(new ArrayList<>(l));
        else
{
        f(n.left,ans,l);
        f(n.right,ans,l);
}
        l.remove(l.size()-1); // to remove while i backtrack 
        
        
    }
}
        
