class pair
{
    String word;
    int level;
    pair(String a,int n)
    {
        this.word=a;
        this.level=n;
    }
}

class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashSet<String> h=new HashSet<>();
        for(String s:wordList)
        h.add(s);
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(startWord,1));
        h.remove(startWord);
        while(!q.isEmpty())
        {
            pair p=q.poll();
            String wd=p.word;
            int lvl=p.level;
            int l=wd.length();
            if(wd.equals(targetWord))
            return lvl;
            for(int i=0;i<l;i++)
            {
                for(char c='a';c<='z';c++)
                {
                    String newWd;
                    if(i+1>=l)
                    newWd=wd.substring(0,i)+c;
                else
                  newWd=wd.substring(0,i)+c+wd.substring(i+1,l);
                  
                  if(h.contains(newWd))
                  {
                      //System.out.println(newWd);
                      q.offer(new pair(newWd,lvl+1));
                      h.remove(newWd);
                  }
                }
            }
        }
        return 0;
    }
}
