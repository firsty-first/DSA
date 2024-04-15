
//things to note is that we do not do operation on reaching null as we will reach null twice for every leaf node 
//n.left=null and n.right=null
// we rather go for keepiing track and forming number and adding when i reach a leaf node i return that number 
//and then add l+r;


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
