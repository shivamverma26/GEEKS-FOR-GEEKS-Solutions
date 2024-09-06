//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            String a1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[2][N];
            for(int i = 0;i < N; i++)
                mat[0][i] = Integer.parseInt(a[i]);
            for(int i = 0;i < N; i++)
                mat[1][i] = Integer.parseInt(a1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxSum(N, mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int solve(int i,int mat[][],int dp[]){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        
        int take=0,notTake=0;
        notTake=solve(i-1,mat,dp);
        take=solve(i-2,mat,dp)+Math.max(mat[0][i],mat[1][i]);
        return dp[i]=Math.max(take,notTake);
        
        
    }
    static int maxSum(int N, int mat[][])
    {
        // code here
        int dp[]=new int[N+1];
        Arrays.fill(dp,-1);
        return solve(N-1,mat,dp);
    }
}