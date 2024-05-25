class Solution {
   List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
      ans=new ArrayList<>();
      int n=s.length();
      int m=wordDict.size();
      HashSet<String> set=new HashSet<>();
        boolean dp[][]=new boolean [n+1][m+1];
   
          for(String wd:wordDict)
          {
            set.add(wd);
          }
          f(s,set,0,new ArrayList<>());
          return ans;
        
    }
    // in worbreak 1 we chose to rather iterate on word dict and tried matching it with s here we need all the combination of match not just one and in no way awe can modify that to implement like this so 
    // this time we iterate on s using recusion and insidfe function we go from i to len(s) to try searching for all the combination of wordws in dict
    void f(String s, HashSet<String> set,int ind ,   List<String> l)
    {
        int ln=s.length();
      if(ind==s.length())
      {
        // for(String wrd:l)
        // ans.add(wrd+" ");
        ans.add(String.join(" ", l));
      return;}
   //i always had ofusion why rec+backtracking over 2 loops , this solves my doubt , via recusrsion we can make infiote calls satisfying the codition 
        for(int j=ind;j<ln;j++)
        {
          String wd=s.substring(ind,j+1);
           
          if(set.contains(wd))
          { System.out.println(wd);
            l.add(wd);
          
            f(s,set,j+1,l);
            l.remove(l.size()-1);
          }
        
      }

    }
}
