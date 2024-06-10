class Solution {
    public int[] findPeakGrid(int[][] mat) {
      int n=mat.length;
        int l=0,h=mat.length;
        int ans[]=new int[2];
        while(l<=h)
        {
          int mid=(l+h)/2;
          int ind=findMax(mat[mid]);
          int left=mid-1>=0?mat[mid-1][ind]:-1;
          int right=mid+1<n?mat[mid+1][ind]:-1;
 if(mat[mid][ind]>right && mat[mid][ind]>left)
          {
            ans[0]=mid;
            ans[1]=ind;
            return ans;
          }
          else if(mat[mid][ind]>left)
          l=mid+1;
          else
          h=mid-1;
        }
        return ans;
    }
    int findMax(int a[])
    {
      int mx=0,ind =0;
      for(int i=0;i<a.length;i++)
      {
        if(a[i]>mx)
        {
          ind=i;
          mx=a[i];
        }
      }
          return ind;
    }
}
