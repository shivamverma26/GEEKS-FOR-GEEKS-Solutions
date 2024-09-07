//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Zeroes {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution g = new Solution();
            head = g.moveZeroes(head);
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
*/

// Class definition for a linked list node


class Solution {
    public Node moveZeroes(Node head) {
        if (head == null) {
            return null; 
        }

        Node prev = null;
        Node curr = head;
        int zeroCount = 0;

        while (curr != null) {
            if (curr.data == 0) {
                zeroCount++; 

                if (prev == null) {  
                    head = curr.next; 
                } else {
                    prev.next = curr.next;
                }
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        for (int i = 0; i < zeroCount; i++) {
            Node newZeroNode = new Node(0);
            newZeroNode.next = head;
            head = newZeroNode;
        }

        return head;  
    }
}
