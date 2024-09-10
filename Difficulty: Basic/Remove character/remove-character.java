//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String string1 = read.readLine();
            String string2 = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.removeChars(string1,string2) );
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    static String removeChars(String string1, String string2) {
        int index = 0;
        String arr[] = new String[string1.length()]; // Correct variable name

        for (int i = 0; i < string1.length(); i++) {
            boolean found = false;
            for (int j = 0; j < string2.length(); j++) { // Use j for the inner loop
                char ch = string2.charAt(j); // Use j to get characters from string2

                if (ch == string1.charAt(i)) {
                    found = true;
                    break;
                }
            }
            if (!found) { // If character is not found in string2
                if (index < arr.length) { // Ensure we don't exceed array bounds
                    arr[index] = Character.toString(string1.charAt(i)); // Convert char to String and assign it to the array
                    index++;
                }
            }
        }

        // Convert the array to a single string before returning
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) { // Correct loop to use index
            sb.append(arr[i]);
        }

        return sb.toString();
    }

   
}