//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static long mod=1000000007;
    public static long solver(long[]dp,int n)
    {
        if(n<=2) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=(solver(dp,n-1)%mod+(n-1)*solver(dp,n-2)%mod)%mod;
    }
    public long countFriendsPairings(int n) 
    { 
       //code here
      long dp[]=new long[n+1];
      Arrays.fill(dp,-1);
     
      return solver(dp,n);
    }
}    
 