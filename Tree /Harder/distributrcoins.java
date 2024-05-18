 pair post(TreeNode n)
    {

      if(n==null)
    {
     return new pair(0,0);
     }
     pair p1= post(n.left);
     pair p2= post(n.right);
     int size=1+p1.size+p2.size;
     int coins=n.val+p1.coins+p2.coins;
     res=res+Math.abs(size-coins);
      return new pair(size,coins);
    }
