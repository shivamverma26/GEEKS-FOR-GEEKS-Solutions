//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        int left=0;
        int right=n-1;
        long res=0;
        int maxleft=0;
        int maxright=0;
        while(left<=right){
            if(arr[left]<=arr[right]){
                if(arr[left]>=maxleft) maxleft =arr[left];
                else res+=maxleft-arr[left];
                left++;
            }
            else {
                 if(arr[right]>=maxright) maxright =arr[right];
                else res+=maxright-arr[right];
                right--;
            }
        }
        
        return (int)res;
    }
}
