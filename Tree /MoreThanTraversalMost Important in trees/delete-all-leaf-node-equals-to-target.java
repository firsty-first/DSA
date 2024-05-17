class Solution {
  boolean flag;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
      flag=true;
      TreeNode r=root;
      int c=target;
    
       return   f(root,target);
          
            }
   TreeNode f( TreeNode n, int target) {
        if (n == null)
            return null;

        

       n.left= f(n.left, target);
       n.right= f( n.right, target);
        if (n.left == null && n.right == null && n.val == target) {
       
          
               return null;
        }
        return n;
    }
}
