//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            int[] arr = new int[inputArray.length];
            for (int j = 0; j < inputArray.length; j++) {
                arr[j] = Integer.parseInt(inputArray[j]);
            }
            int k = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Solution solution = new Solution();
            if (solution.canFillContainer(arr, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public boolean canFillContainer(int[] a, int k) {
        // code here
        int n=a.length;
        boolean dp[][]=new boolean[n+1][k+1];
       for(int i=0;i<n+1;i++)
        {
       for(int j=0;j<k+1;j++)
       {
           if(i==0)
               dp[i][j]=false;
           
           if(j==0)
               dp[i][j]=true;
           
       }
   }
   for(int i=1;i<n+1;i++)
   {
       for(int j=1;j<k+1;j++)
       {
           if(a[i-1]<=j)
               dp[i][j]=(dp[i][j-a[i-1]] || dp[i-1][j]);
           
           else
               dp[i][j]=dp[i-1][j];
           
       }
   }
   
   return dp[n][k];
   
}
    }
