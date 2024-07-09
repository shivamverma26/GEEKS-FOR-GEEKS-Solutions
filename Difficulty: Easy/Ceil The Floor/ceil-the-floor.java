//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Pair ans = new Solve().getFloorAndCeil(arr, n, x);
            System.out.println(ans.floor + " " + ans.ceil);
        }
    }
}

class Pair {
    int floor, ceil;

    Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}

// } Driver Code Ends


//User function Template for Java




class Solve {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= x && arr[i] > floor) {
                floor = arr[i];
            }
            if (arr[i] >= x && arr[i] < ceil) {
                ceil = arr[i];
            }
        }

        // Handling cases where no valid floor or ceil is found
        if (floor == Integer.MIN_VALUE) {
            floor = -1; // or any indication that floor is not found
        }
        if (ceil == Integer.MAX_VALUE) {
            ceil = -1; // or any indication that ceil is not found
        }

        return new Pair(floor, ceil);
    }
}