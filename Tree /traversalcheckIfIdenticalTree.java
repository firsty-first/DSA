class Solution {
    static boolean flag;
    public static boolean isSubtree(Node T, Node S) {
        // add code here.
         if(T == null){
            return false;
        }
        if(T.data==S.data)
        {
            if(f(T,S))
            return true;
        }
       return isSubtree(T.left, S) || isSubtree(T.right, S);
    
    }
   static  boolean f(Node t,Node s)
    {
        if(t==null && s==null)
        {
       
            return true;
     
        }
      else   if(t==null || s==null)
        return false;
    
        if(t.data==s.data)
        {
         return ( f(t.left,s.left) && f(t.right,s.right));
        }
        else 
        {
            return false;
        }
      
    }
}
