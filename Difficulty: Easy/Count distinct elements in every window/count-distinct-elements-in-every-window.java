//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int A[], int k) {
        // code here
        int n = A.length;
         ArrayList<Integer> li=new ArrayList<>();
        HashMap <Integer,Integer> mp=new HashMap <>();
        for(int i=0;i<k;i++){
            mp.put(A[i],mp.getOrDefault(A[i],0)+1);
        }
        li.add(mp.size());
        for(int i=k;i<n;i++){
            if(mp.get(A[i-k])==1)
            mp.remove(A[i-k]);
            
            else mp.put(A[i-k],mp.get(A[i-k])-1);
            
            mp.put(A[i],mp.getOrDefault(A[i],0)+1);
            li.add(mp.size());
        }
        return li;
    }
}
