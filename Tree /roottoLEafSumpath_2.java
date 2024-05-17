
class Solution {
  int s;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      s=0;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        f(root,targetSum,l,ans);
        return ans;
    }
    boolean f(TreeNode n,int t,List<Integer> l,List<List<Integer>> ans)
    {
      if(n==null)
      return false;
      s=s+n.val;
l.add(n.val);
 System.out.println(s);
      if(n.left==null && n.right==null)
      {
         System.out.print("hii");

        if(s==t)
        {
          for(int i:l)
          System.out.print(i+",");
         List<Integer> temp= new ArrayList<>(l);

          ans.add(temp);
//return true;
        }
       
      }

      if(f(n.left,t,l,ans)==true || f(n.right,t,l,ans)==true)
      {
        return true;
      }
     System.out.println(s+"-"+n.val);
s=s-n.val;
l.remove(l.size()-1);
return false;

    }
}
