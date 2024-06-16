class Solution {
    public static ArrayList<String> sortItems(int n, String[] items) {
        // code here
        Arrays.sort(items,(x,y)->
        {
            if(x.length()==y.length())
            return x.compareTo(y);
            else
            return x.length()-y.length();
        });
         ArrayList<String> l=new ArrayList<>();
         for(String s:items)
         {
             l.add(s);
         }
         return l;
    }
}
