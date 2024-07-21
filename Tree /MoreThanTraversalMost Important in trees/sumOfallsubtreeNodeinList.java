
class Solution {
    long s=0;
    int mod=1000000007;
    public int maxProduct(TreeNode root) {
        List<Long> l=new ArrayList<>();
     long sum=f(root,l);
      for(long  i:l)
     s=Math.max(s,(sum-i)*i);
      return (int)(s%mod);
     
    }
   long f(TreeNode n, List<Long> l)
    {
        if(n==null)
        return 0;
        int p=0;
    final  long left=f(n.left,l);
     final  long r=f(n.right,l);
     final long sum=left+r+n.val;
      l.add(sum);
          return sum;
        
    }
    
}
