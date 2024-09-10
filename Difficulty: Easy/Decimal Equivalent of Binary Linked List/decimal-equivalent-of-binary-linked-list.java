//{ Driver Code Starts
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

class LinkedList1 {
    Node head; // head of lisl

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;

            temp.next = node;
        }
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t > 0) {

            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node copy = head;

            for (int i = 1; i < s.length; i++) {
                Node temp = new Node(Integer.parseInt(s[i]));
                copy.next = temp;
                copy = copy.next;
            }
            System.out.println(new Solution().DecimalValue(head));
            t--;
        }
    }
}

// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}
This is method only submission.  You only need to complete the method. */

class Solution {
    static long mod = 1000000007;

    long DecimalValue(Node head) {
        int count = 0;
        long sum = 0;
        Node temp = head;

        // Count the number of nodes in the linked list
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        temp = head;
        count--;

        // Calculate the decimal value of the binary number
        while (temp != null) {
            // Calculate 2^count using bit shifting to avoid floating point issues
            long powerOfTwo = powerMod(2, count, mod);
            sum = (sum + (temp.data * powerOfTwo) % mod) % mod;
            count--;
            temp = temp.next;
        }

        return sum;
    }

    // Function to calculate (base^exp) % mod using modular exponentiation
    long powerMod(long base, int exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;  // Divide exponent by 2
        }
        return result;
    }
}
