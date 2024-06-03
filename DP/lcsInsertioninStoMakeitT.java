class Solution {
    public int appendCharacters(String s, String t) {
      int 
        return t.length()-lcs(0,0,s,t);
    }
    int lcs(int i,int j,String s,String t)
    {
      if(s.length()==i || t.length()==j )
      return 0;
      int p=0,q=0;
      if(s.charAt(i)==t.charAt(j))
      return 1+ lcs(i+1,j+1,s,t);
      return lcs(i+1,j,s,t);

    }
}
