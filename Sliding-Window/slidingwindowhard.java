class Solution {
    public int subarraysWithKDistinct(int[] arr, int k) {
      int n=arr.length;
   return f(arr,n,k)-f(arr,n,k-1);
  }
  static int f(int arr[], int n, int k)
  {
  HashMap<Integer,Integer> h=new HashMap<>();
    int i=0,j=0,c=0;
    while(j<n )
    {
        h.put(arr[j],h.getOrDefault(arr[j],0)+1);
        while(h.size()>k)
        {
            h.put(arr[i],h.get(arr[i])-1);
            if(h.get(arr[i])==0)
            h.remove(arr[i]);
            i++;
           
           
            
        }
        c=c+(j-i+1);
        j++;
    }
    return c;
  }
}
     
