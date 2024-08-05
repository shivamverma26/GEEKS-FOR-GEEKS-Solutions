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
                    System.out.println(ob.minSteps(n));
                    
                }
        }
}    
// } Driver Code Ends


class Solution{
    public int solver(int n, int dp[]){
      if(n==2||n==3) return 1;
      
      if(dp[n]!=-1) return dp[n];
      int div1=Integer.MAX_VALUE,div2=Integer.MAX_VALUE,div3=Integer.MAX_VALUE;
      
      if(n%2==0) div2 = solver(n/2,dp);
      
       if(n%3==0) div3 = solver(n/3,dp);
       
         div1 = solver(n-1,dp);
        
        return dp[n]=1+Math.min(div3,Math.min(div2,div1));
      
    }
	public int minSteps(int n) 
	{ 
	    // Your code goes here
	    if(n==1) return 0;
	  int dp[]= new int[n+1];
	  Arrays.fill(dp,-1);
	  return solver(n,dp);
	} 
}
