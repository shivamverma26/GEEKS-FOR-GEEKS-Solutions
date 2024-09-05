//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


 class Solution {

    public static int eggDropHelper(int n, int k, int[][] dp) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }

        if (dp[n][k] != -1) {
            return dp[n][k];
        }

        int minCost = Integer.MAX_VALUE;

        for (int f = 1; f <= k; f++) {
            int eggBreaks = eggDropHelper(n - 1, f - 1, dp);
            int eggDoesNotBreak = eggDropHelper(n, k - f, dp);
            int cost = Math.max(eggBreaks, eggDoesNotBreak);
            minCost = Math.min(minCost, cost);
        }

        return dp[n][k] = 1 + minCost;
    }

    public static int eggDrop(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return eggDropHelper(n, k, dp);
    }
}