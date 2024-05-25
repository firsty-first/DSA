class Solution {
     private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> l=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        f(nums,0,ans,l);
        return ans;

    }
    void f(int a[],int ind,List<List<Integer>> ans,List<Integer> l)
    {
      if(ind==a.length)
      {
      List<Integer> currentPermutation = new ArrayList<>();
            for (int num : a) {
                currentPermutation.add(num);
            }
            ans.add(currentPermutation);
        return;
      }
   for(int i=ind;i<a.length;i++)
   {
    swap(a,ind,i);
    f(a,ind+1,ans,l);
    swap(a,ind,i);
   }
    }
}
