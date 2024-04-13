

class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        long ans[]=new long[n];
        Stack<Long> stk=new Stack<>();
        // Your code here
        for(int i=n-1;i>=0;i--)
        {
            while(stk.isEmpty()==false && stk.peek()<=arr[i])
            {
                stk.pop();
            }
           if(stk.isEmpty()==false)
           ans[i]=stk.peek();
           else
           ans[i]=-1;
           stk.push(arr[i]);
        }
        return ans;
    } 
}
//TC:O(2N) bcz stack while loop will run for maximum of N times
//brute force o(N^2) in worst case
