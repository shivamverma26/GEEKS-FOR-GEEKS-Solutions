//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        
        // Separate positive and negative numbers
        for (int num : arr) {
            if (num < 0)
                neg.add(num);
            else
                pos.add(num);
        }
        
        int i = 0, j = 0, k = 0;
        
        // Clear original list to refill it
        arr.clear();
        
        // Merge positive and negative numbers alternately
        while (i < neg.size() && j < pos.size()) {
            arr.add(pos.get(j++));
            arr.add(neg.get(i++));
        }
        
        // Append remaining positive numbers
        while (j < pos.size()) {
            arr.add(pos.get(j++));
        }
        
        // Append remaining negative numbers
        while (i < neg.size()) {
            arr.add(neg.get(i++));
        }
    }
}
