//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to flatten a linked list
     public static Node merge(Node head1, Node head2) {
      
        // A dummy first node to store the result list
        Node dummy = new Node(-1);

        // Tail points to the last result node to add new
        // nodes to the result
        Node tail = dummy;

        // Iterate till either head1 or head2 does not reach
        // null
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
              
                // Append head1 to the result
                tail.bottom = head1;
                head1 = head1.bottom;
            }
            else {
              
                // Append head2 to the result
                tail.bottom = head2;
                head2 = head2.bottom;
            }

            // Move tail pointer to the next node
            tail = tail.bottom;
        }

        // Append the remaining nodes of the non-null list
        if (head1 != null)
            tail.bottom = head1;
        else 
            tail.bottom = head2;
        
        return dummy.bottom;
    }
    Node flatten(Node root) {
        // code here
       
        if (root == null || root.next == null)
            return root;

        // Recur for next list
        root.next = flatten(root.next);

        // Now merge the current and next list
        root = merge(root, root.next);

        // Return the root
        return root;
    }
}

//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline

        while (t-- > 0) {
            String[] workArray = sc.nextLine().trim().split(" ");
            int n = workArray.length;

            Node head = null;
            Node pre = null;

            for (int i = 0; i < n; i++) {
                int m = Integer.parseInt(workArray[i]);
                int data = sc.nextInt();
                Node temp = new Node(data);
                if (head == null) {
                    head = temp;
                    pre = temp;
                } else {
                    pre.next = temp;
                    pre = temp;
                }

                Node preB = temp;
                for (int j = 0; j < m - 1; j++) {
                    int tempData = sc.nextInt();
                    Node tempB = new Node(tempData);
                    preB.bottom = tempB;
                    preB = tempB;
                }
            }

            // Consume the remaining newline if there's any
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            Solution ob = new Solution();
            Node root = ob.flatten(head);
            printList(root);
        }
        sc.close();
    }
}

// } Driver Code Ends