//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends




class Solution 
{ 
    static int kSU(int W, int wt[], int val[], int n, int[][] dp)
    {
        if (n == 0 || W == 0)
            return 0;
        
        if (dp[n][W] != -1)
            return dp[n][W];
        
       
        if (wt[n - 1] <= W)
            return dp[n][W] = Math.max(
                val[n - 1] + kSU(W - wt[n - 1], wt, val, n - 1, dp),
                kSU(W, wt, val, n - 1, dp)
            );
        else
            return dp[n][W] = kSU(W, wt, val, n - 1, dp);
    }
    
  
    static int knapSack(int W, int wt[], int val[]) 
    { 
        int n=val.length;
        int[][] dp = new int[n + 1][W + 1];
        
        
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        
        return kSU(W, wt, val, n, dp);
    }
}

