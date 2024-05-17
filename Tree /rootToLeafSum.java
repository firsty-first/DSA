class Solution {
  int s;
    public boolean hasPathSum(TreeNode root, int t) {
        s=0;
        return f(root,t);
    }
     boolean f( TreeNode n, int t) {
        if (n == null)
            return false;
System.out.println(n.val);
  s=s+n.val;
  if (n.left == null && n.right == null ) {
       
          if(s==t)
               return true;
              
        }
        
      //  boolean p,q;
      //  p=f(n.left, s-n.val);
      //  q= f( n.right,s-n.val);
    
if(f(n.left, t) || f( n.right,t))
{
  return true;
}
System.out.println(s+"-"+n.val);
s=s-n.val;
return false;
     
    }
}
