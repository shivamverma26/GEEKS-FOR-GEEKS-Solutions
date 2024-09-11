//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    Integer nextInt() { return Integer.parseInt(next()); }
}

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node ans = ob.divide(head);
            printList(ans);
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/


class Solution {
    Node divide(Node head) {
        if (head == null || head.next == null) {
            return head;  // No need to rearrange if list is empty or has one node
        }

        Node evenStart = null, evenEnd = null;  // Heads and tails for the even list
        Node oddStart = null, oddEnd = null;    // Heads and tails for the odd list
        Node current = head;  // Pointer to traverse the original list

        // Traverse the list and segregate even and odd nodes
        while (current != null) {
            if (current.data % 2 == 0) {  // If the node contains an even number
                if (evenStart == null) {
                    evenStart = current;  // Initialize the even list
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = current;  // Append to the even list
                    evenEnd = evenEnd.next;
                }
            } else {  // If the node contains an odd number
                if (oddStart == null) {
                    oddStart = current;  // Initialize the odd list
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = current;  // Append to the odd list
                    oddEnd = oddEnd.next;
                }
            }
            current = current.next;  // Move to the next node
        }

        // If no even numbers were found, the list is all odd
        if (evenStart == null) {
            return head;  // No rearrangement needed
        }

        // Link the even list to the odd list
        evenEnd.next = oddStart;

        // Mark the end of the odd list as null (since it's the last node)
        if (oddEnd != null) {
            oddEnd.next = null;
        }

        // Return the new head which is the start of the even list
        return evenStart;
    }
}

