//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
   static int dp[][]=new int [1001][1001];

    public static int solve(String s1,int l,int r){
        if(l>=r) return 1;

        if(dp[l][r]!=-1) return dp[l][r];
        if(s1.charAt(l)==s1.charAt(r)) return dp[l][r]=solve(s1,l+1,r-1);
        else return dp[l][r]= 0;
    }
    static String longestPalin(String s1){
        
        int n=s1.length();
        int mx=Integer.MIN_VALUE;
        int start=0;
        
        for(int i=0;i<1000;i++)
        Arrays.fill(dp[i],-1);

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
              if(solve(s1,i,j)!=0){
              if(j-i+1>mx){
                  mx=j-i+1;
              start=i;
              }
              }
            
            }
        }
        return s1.substring(start,start+mx);
        
        
    }
}