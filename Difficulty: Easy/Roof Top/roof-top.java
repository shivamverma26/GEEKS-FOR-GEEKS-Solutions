//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String st[] = read.readLine().trim().split("\\s+");
            int n = st.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[(int)i] = Integer.parseInt(st[(int)i]);

            System.out.println(new Solution().maxStep(arr));
        }
    }
}

// } Driver Code Ends






class Solution
{
    //Function to find maximum number of consecutive steps 
    //to gain an increase in altitude with each step.
    static int maxStep(int A[])
    {
        // Your code here
        int N = A.length;
        int sum=0;
        int longest=0;
        for(int i=0;i<N-1;i++){
            if(A[i]<A[i+1]){
                sum++;
            }
            else{
                sum=0;
            }
            longest=Math.max(sum,longest);
        }
        return longest;
    }
    
}