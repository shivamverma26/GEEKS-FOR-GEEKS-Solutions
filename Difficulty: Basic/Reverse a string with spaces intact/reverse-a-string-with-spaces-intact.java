//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0)
        {
            String s;
            s = br.readLine();
            
            Solution ob = new Solution();
            
            System.out.println(ob.reverseWithSpacesIntact(s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    String reverseWithSpacesIntact(String S) {
        StringBuilder sb = new StringBuilder(S);
        
        int i = 0;
        int j = S.length() - 1;
        
        while (i < j) {
            // Skip spaces for i
            while (i < j && sb.charAt(i) == ' ') {
                i++;
            }
            // Skip spaces for j
            while (i < j && sb.charAt(j) == ' ') {
                j--;
            }
            
            // Swap non-space characters
            if (i < j) {
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);
                i++;
                j--;
            }
        }
        
        return sb.toString();
    }
}
