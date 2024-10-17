//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);

            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            Node head = new Node(arr.get(0));
            Node tail = head;

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends




// User function Template for Java
/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
    // Function to split the linked list into two alternating sublists
    Node[] alternatingSplitList(Node head) {
        if (head == null) {
            return new Node[]{null, null};  // If the list is empty, return two null lists
        }

        Node first = null, second = null;  // Initialize the heads of the two sublists
        Node firTail = null, secTail = null;  // Tails to track the last node of the two lists

        Node temp = head;
        boolean alternate = true;  // To alternate between first and second list

        // Loop through the original list
        while (temp != null) {
            if (alternate) {
                // Adding to the first list
                if (first == null) {
                    first = temp;  // Initialize the first list
                    firTail = first;
                } else {
                    firTail.next = temp;  // Add new node to the end of the first list
                    firTail = firTail.next;
                }
            } else {
                // Adding to the second list
                if (second == null) {
                    second = temp;  // Initialize the second list
                    secTail = second;
                } else {
                    secTail.next = temp;  // Add new node to the end of the second list
                    secTail = secTail.next;
                }
            }

            temp = temp.next;  // Move to the next node
            alternate = !alternate;  // Toggle between the first and second lists
        }

        // Ensure the last node of both lists points to null
        if (firTail != null) firTail.next = null;
        if (secTail != null) secTail.next = null;

        // Return the two alternating sublists
        return new Node[]{first, second};
    }
}
