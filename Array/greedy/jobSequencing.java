class pair
{
    int start,end;
    pair(int start,int end)
    {
        this.start=start;
        this.end=end;
    }
}
class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        pair p[]=new pair[n];
        for(int i=0;i<n;i++)
        p[i]=new pair(start[i],end[i]);
       Arrays.sort(p, (x, y) -> {
    if (x.end != y.end) {
        return x.end - y.end; // Primary sorting criterion: end time
    } else {
        return x.start - y.start; // Secondary sorting criterion: start time
    }
});
int lastend=0;
int c=0;
for(int i=0;i<n;i++)
{
    if(p[i].start>lastend)
    {
        c++;
        lastend=p[i].end;
    }
}
return c;

        
    }
}
