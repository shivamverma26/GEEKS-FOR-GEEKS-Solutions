//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.primeSum(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int primeSum(int N){
        // code here
        int sum=0;
        int temp=0;
        while(N>0){
            temp=N%10;
            
            if(temp==2||temp==3||temp==5||temp==7)
            sum+=temp;
            
            N/=10;
            
        }
        return sum;
    }
}