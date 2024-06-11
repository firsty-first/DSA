//questions sounds like dp but is greedy if u thnik of sorting it on absolute differrence of  a and b 
class pair
{
    int x,y,diff;
    pair(int x,int y,int diff)
    {
        this.x=x;
        this.y=y;
        this.diff=diff;
    }
}

class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // code here
        pair p[]=new pair[n];
     long s=0;
        for(int i=0;i<n;i++)
        {
            p[i]=new pair(arr[i],brr[i],Math.abs(arr[i]-brr[i]));
            
        }
        Arrays.sort(p,(a,b)->b.diff-a.diff);
        for(int i=0;i<n;i++)
        {
            if(x==0)
            {
                s=s+p[i].y;
          
            }
            else if(y==0)
            {
                s=s+p[i].x;
            }
            else
            {
                if(p[i].x>=p[i].y)
                {
                    s=s+p[i].x;
                    x--;
                }
                else
             {   s=s+p[i].y;
                y--;}
            }
        }
        return s;
    }
}
