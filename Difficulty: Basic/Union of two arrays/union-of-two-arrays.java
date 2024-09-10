//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            // Reading the first array
            String line1 = read.readLine().trim();
            String[] numsStr1 = line1.split(" ");
            int[] a = new int[numsStr1.length];
            for (int i = 0; i < numsStr1.length; i++) {
                a[i] = Integer.parseInt(numsStr1[i]);
            }

            // Reading the second array
            String line2 = read.readLine().trim();
            String[] numsStr2 = line2.split(" ");
            int[] b = new int[numsStr2.length];
            for (int i = 0; i < numsStr2.length; i++) {
                b[i] = Integer.parseInt(numsStr2[i]);
            }

            // Creating an instance of the Solution class
            Solution ob = new Solution();

            // Calling doUnion method and printing the result
            System.out.println(ob.doUnion(a, b));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int doUnion(int arr1[], int arr2[]) {
        // Your code here
        HashMap<Integer,Integer>mp=new HashMap<Integer,Integer>();
        
        int n1=arr1.length;
        int n2=arr2.length;
        
        for(int i=0;i<n1;i++){
            mp.put(arr1[i],mp.getOrDefault(arr1[i],0)+1);
        }
        
        for(int i=0;i<n2;i++){
            if(!mp.containsKey(arr2[i]))
            mp.put(arr2[i],mp.getOrDefault(arr2[i],0)+1);
        }
        return mp.size();
        
    }
}