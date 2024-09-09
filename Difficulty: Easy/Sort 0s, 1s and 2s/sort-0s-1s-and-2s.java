//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function template for Java

class Solution
{
    public static void swap(ArrayList<Integer> a, int i,int j)
    {

        int tmp=a.get(i);
        a.set(i,a.get(j));
        a.set(j,tmp);
        
    }
    public static void sort012(ArrayList<Integer> a)
    {
        // code here 
        int n=a.size();
        int low=0;
        int high=n-1;
        int mid=0;
        while(mid<=high){
            if(a.get(mid)==0){
                swap(a,mid,low);
                mid++;
                low++;
            }
            else if(a.get(mid)==1) mid++;
            else{
                swap(a,mid,high);
                high--;
            }
        }
        
    }
}
