class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy=root,n=root;
        if(n==null)
        return null;
        
        if(n.val==key)
        return helper(n);
         
        while(n!=null)
        {
            if(n.val<key)
            {
                //right
                if(n.right!=null && n.right.val == key)
                n.right=helper(n.right);
                else
                n=n.right;
            }
            else
            {
              //left
                if(n.left!=null && n.left.val == key)
                n.left=helper(n.left);
                else
                n=n.left;   
            }
        }
        return dummy;


    }
    TreeNode helper(TreeNode n)
    {
        if(n.left==null)
        return n.right;
            else if(n.right==null)
        return n.left;
        else
        {
            TreeNode rightchild=n.right;
            TreeNode lastright=findLastRight(n.left);
            lastright.right=rightchild;
        }
        return n.left;

    }
    TreeNode findLastRight(TreeNode n)
    {
        if(n.right==null)
        return n;
        return findLastRight(n.right);
    }
}
