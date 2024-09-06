//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] cost = new int[N];
            
            for(int i=0 ; i<N ; i++)
                cost[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minCostClimbingStairs(cost,N));
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    
    public static int solver(int dp[],int cost[],int n){
        if(n==1) return cost[n];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=Math.min(solver(dp,cost,n-1),solver(dp,cost,n-2))+cost[n];
        
        
    }
    static int minCostClimbingStairs(int[] cost , int N) {
        //Write your code here
        
        int dp[]=new int[N+1];
        Arrays.fill(dp,-1);
        
        int ans=Math.min(solver(dp,cost,N-1),solver(dp,cost,N-2));
        return ans;
    }
};