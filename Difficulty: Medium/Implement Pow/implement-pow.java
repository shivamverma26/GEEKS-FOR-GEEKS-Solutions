//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    double power(double b, int e) {
        // code here
              if(b == 0) return 0.0;
        if(e == 0) return 1;
        boolean isNegative = false;
        if(e < 0) {
            isNegative = true;
            e = Math.abs(e);
        }
        double ans = 1;
       
        while(e > 0){
            if(e % 2 == 1) ans *= b;
            b *= b;
            e /= 2;
        }
        if(isNegative){
            ans = 1 / ans;
        }
        
        return ans;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends