//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        
        // Brute Force Approach --> Preprocessing Array(prefix max and suffix max)
        
        // int left[] =new int[n];
        // int right[] =new int[n];
        
        // int count =0;
        // left[0]=arr[0];
        // right[n-1]=arr[n-1];
        
        // for(int i=1;i<n;i++)
        // left[i]=Math.max(arr[i],left[i-1]);
        
        // for(int i=n-2;i>=0;i--)
        // right[i]=Math.max(arr[i],right[i+1]);
        
        // for(int i=0;i<n;i++){
        //   count+=(Math.min(left[i],right[i])-arr[i]); 
        // }
        // return count;
        
        // TC ---> O(N)
        // SC ---> O(2N)
        
        
        // Optimal Approach --> Two pointer approach
        
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
        
        return res;
    } 
}
        // TC ---> O(N)
        // SC ---> O(1)