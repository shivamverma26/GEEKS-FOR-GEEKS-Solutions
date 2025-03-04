//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int lis(int a[]) {
        // code here
        int size = a.length;
         if (size == 0) {
            return 0;
        }

        int[] piles = new int[size];
        int numPiles = 0;

        for (int num : a) {
            int left = 0, right = numPiles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (piles[mid] >= num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == numPiles) {
                numPiles++;
            }
            piles[left] = num;
        }

        return numPiles;
    }
}