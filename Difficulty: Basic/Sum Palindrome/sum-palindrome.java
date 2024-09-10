//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumPalindrome(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static long reverse(long a){
        long num=0;
        while(a!=0){
            long rem=a%10;
            a/=10;
            num=num*10+rem;
        }
        return num;
    }
    static long isSumPalindrome(long n) {
        // code here
        int i=0;
        long r=0;
        if(n==reverse(n)){
            return n;
        }
        while(i<5){
            r=n+reverse(n);
            if(r!=reverse(r)){
                n=r;
                i++;
            }
            else 
            return r;
        }
        
        return -1;
        
    }
}