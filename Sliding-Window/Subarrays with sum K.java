
class Solution
{
    static int findSubArraySum(int arr[], int N, int k)
    {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int c=0,s=0;
        int pre=0;
        for(int i=0;i<N;i++)
        {
            pre+=arr[i];
            int tar=pre-k;
            c=c+map.getOrDefault(tar,0);
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return c;
    }
}
