//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            
            String a = sc.next();
            String b = sc.next();
            Solution ob = new Solution();
            if(ob.isSubSequence(a,b))
            System.out.println(1);
            else
            System.out.println(0);
 		
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    boolean isSubSequence(String A, String B){
        
        // dp solution
        // int x=s1.length();
        // int y=s2.length();
        //     int[][] dp = new int[x + 1][y + 1];

        // for (int i = 0; i <= x; i++) {
        //     for (int j = 0; j <= y; j++) {
        //         if (i == 0 || j == 0) {
        //             dp[i][j] = 0;
        //         } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        //             dp[i][j] = dp[i - 1][j - 1] + 1;
        //         } else {
        //             dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        //         }
        //     }
        // }
        // return dp[x][y]==x?true:false;
       int indexA = 0;
        int indexB = 0;

        while (indexA < A.length() && indexB < B.length()) {
            if (A.charAt(indexA) == B.charAt(indexB)) {
                indexA++;
            }
            indexB++;
        }

        return indexA == A.length();
    }
}