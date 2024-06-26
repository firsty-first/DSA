class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return f(0,nums.length-1,nums);
    }
  TreeNode f(int l,int r,int a[])
    {
        if(l>r)
        return null;
        int mid=l+(r-l)/2;
        TreeNode n=new TreeNode(a[mid]);
        n.left=f(l,mid-1,a);
        n.right=f(mid+1,r,a);
        return n;
    }
