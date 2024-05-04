
class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int n=s.length();
         HashMap<Character,Integer> h=new HashMap<>();
         int i=0,j=0,mx=-1;
         while(j<n && i<n)
         {
             h.put(s.charAt(j),h.getOrDefault(s.charAt(j),0)+1);
             if(h.size()<k)
             {
               //continue;
             }
             else if(h.size()==k)
             {
                 mx=Math.max(mx,j-i+1);
                
             }
             else
             {
                 //System.out.println("exceeded at:"+s.charAt(j));
                 while(h.size()>k)
                 {
                     h.put(s.charAt(i),h.get(s.charAt(i))-1);
                     if(h.get(s.charAt(i))==0)
                     h.remove(s.charAt(i));
                     i++;
                 }
               
             }
               j++;
             
         }
        
         return mx;
    }
}
