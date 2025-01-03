//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
    
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        
        int presum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            presum ^= arr[i];
            if(map.containsKey(presum^k)){
                ans += map.get(presum^k);
            }
            if(presum == k){
                ans += 1;
            }
            if(map.containsKey(presum)){
                map.put(presum, map.get(presum)+1);
            }
            else{
                map.put(presum,1);
            }
        }
        return ans;
    }
}