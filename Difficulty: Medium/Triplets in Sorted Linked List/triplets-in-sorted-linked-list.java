//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class LinkedList {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int k = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            Solution ob = new Solution();
            int res = ob.countTriplets(head, k);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int countTriplets(Node head, int x) {
        ArrayList<Integer> al = new ArrayList<>();
        
        // Convert linked list to ArrayList
        while (head != null) {
            al.add(head.data);
            head = head.next;
        }
        Collections.sort(al);
        int count = 0;

        // Iterate through each element in ArrayList
        for (int i = 0; i < al.size() - 2; i++) {
            // Initialize two pointers
            int s = i + 1;
            int e = al.size() - 1;

            // Use two-pointer technique to find pairs with the required sum
            while (s < e) {
                int sum = al.get(i) + al.get(s) + al.get(e);

                if (sum == x) {
                    count++;
                    s++;
                    e--;
                } else if (sum < x) {
                    s++;
                } else {
                    e--;
                }
            }
        }

        return count;
    }
}
