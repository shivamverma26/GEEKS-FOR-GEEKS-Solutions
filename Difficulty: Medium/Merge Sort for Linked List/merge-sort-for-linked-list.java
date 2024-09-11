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


// } Driver Code Ends
/*
The structure of linked list is the following

class Node
{
int data;
Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution
{   // FOR GETTING MIDdle element in the ll 
      static Node getMiddle(Node head)
    {
         // Your code here.
      Node  slow = head;
      Node fast = head.next;
      while(fast!=null && fast.next !=null){
          slow = slow.next;
          fast=fast.next.next;
      }
      return slow;
    }
    // for combining the two linked lists 
    static Node mergerll(Node head1 , Node head2){
          Node dummynode = new Node(-1);
          Node current = dummynode;
          while(head1 != null && head2 != null){
                 if(head1.data <head2.data){
                     current.next=head1;
                     current = head1;
                     head1 = head1.next;
                 }else{
                     current.next=head2;
                     current = head2;
                     head2 = head2.next;
                 }
          }
        if(head1 !=null){
            current.next = head1;
        }else{
            current.next = head2;
        }
        
        return dummynode.next;
    }
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head == null || head.next == null){
            return head;
        }
        Node middle = getMiddle(head);
        Node right = middle.next;
        Node left = head;
        middle.next = null;
        left = mergeSort(left);
        right=mergeSort(right);
        return  mergerll(left , right);
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().mergeSort(head);
            printList(head);
        }
    }
}

// } Driver Code Ends