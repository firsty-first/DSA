
class Solution {
    public static int lowerBound(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int a[]) {
       ArrayList<Integer> l=new ArrayList<>();
       l.add(-1);
       for(int i:a)
       {
           if(l.get(l.size()-1)<i)
           l.add(i);
           else
          {
             // insert at 1st ele after i
             int ins=lowerBound(l,i);
         //    System.out.println(ins);
             l.set(ins,i);
             
          }
       }
       return l.size()-1;
    }
}
