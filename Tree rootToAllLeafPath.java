

class Solution {
  static int ans;
    public int sumNumbers(TreeNode root) {
      ans=0;
      int cur=0;
      //  ArrayList<Integer> l=new ArrayList<Integer>();
        return f(root,cur);
       
    }
    static int f(TreeNode n,int cur)
    {
      if(n==null)
      return 0;
    cur=cur*10+n.val;
    if(n.left==null && n.right==null)
    return cur;

     int l= f(n.left,cur);
   ///ans=ans*10+n.val;
    int r= f(n.right,cur);
      return r+l;
    }
}
