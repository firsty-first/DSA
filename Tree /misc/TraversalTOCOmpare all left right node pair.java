   Node f(Node n)
    {
        if(n==null)
        return null;
       n.left=f(n.left);
       n.right=f(n.right);
        if(n.left==null && n.right!=null)
        return n.right;
        else if(n.left!=null && n.right==null)
        return n.left;
        return n;
    }
