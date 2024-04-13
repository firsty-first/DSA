class Solution {
    public int[] nextGreaterElements(int[] arr) 
    {
        int n=arr.length;
     int ans[]=new int[n];
        Stack<Integer> stk=new Stack<>();
        // Your code here
        for(int i=2*n-1;i>=0;i--)
        {
            while(stk.isEmpty()==false && stk.peek()<=arr[i%n])
            {
                stk.pop();
            }
           if(stk.isEmpty()==false)
           ans[i%n]=stk.peek();
           else
           ans[i%n]=-1;
           stk.push(arr[i%n]);
        }
        return ans;   
    }
}
