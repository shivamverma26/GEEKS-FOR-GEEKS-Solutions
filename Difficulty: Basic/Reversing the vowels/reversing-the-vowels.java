//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
           
            Solution ob = new Solution();
            
            System.out.println(ob.modify(s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String modify (String s)
    {
        // your code here
        int i=0;
        int j=s.length()-1;
        StringBuilder sb=new StringBuilder(s);
        
        

        while(i<j){
            if(sb.charAt(i)=='a'||sb.charAt(i)=='e'||sb.charAt(i)=='i'
            ||sb.charAt(i)=='o'||sb.charAt(i)=='u')
           {
                if(sb.charAt(j)=='a'||sb.charAt(j)=='e'||sb.charAt(j)=='i'
            ||sb.charAt(j)=='o'||sb.charAt(j)=='u'){
                char temp=sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                    sb.setCharAt(j, temp);
                i++;
                j--;
            }
             else j--;
           
           } 
         else  i++;
            
        }
        return sb.toString();
    }
}