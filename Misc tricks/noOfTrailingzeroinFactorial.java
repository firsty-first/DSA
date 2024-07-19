class Solution{
    static int trailingZeroes(int N){
        // Write your code here
        int c=0;
        while(N>=5)
        {
            c+=N/5;
            N=N/5;
        }
        return c;
    }
}
