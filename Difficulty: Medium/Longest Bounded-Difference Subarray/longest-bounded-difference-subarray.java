//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends


 class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        Deque<Integer> maxi = new LinkedList<>();
        Deque<Integer> mini = new LinkedList<>();
        int ans = 0, i = 0, j = 0, ii = 0, jj = 0;
        
        while (j < arr.length) {
            while (!mini.isEmpty() && arr[mini.peekLast()] > arr[j]) mini.pollLast();
            while (!maxi.isEmpty() && arr[maxi.peekLast()] < arr[j]) maxi.pollLast();
            
            mini.addLast(j);
            maxi.addLast(j);
            
            while (arr[maxi.peekFirst()] - arr[mini.peekFirst()] > x && i < j) {
                if (i == mini.peekFirst()) mini.pollFirst();
                if (i == maxi.peekFirst()) maxi.pollFirst();
                i++;
            }
            
            if (j - i + 1 > ans) {
                ans = j - i + 1;
                ii = i;
                jj = j;
            }
            j++;
        }
        
        ArrayList<Integer> ans1 = new ArrayList<>();
        for (int k = ii; k <= jj; k++) {
            ans1.add(arr[k]);
        }
        
        return ans1;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends