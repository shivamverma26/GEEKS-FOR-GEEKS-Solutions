//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int data;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Delete_Kth_Node {
    Node head;
    Node tail;

    void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
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

            int k = Integer.parseInt(in.readLine());

            Node ans = new Solution().deleteK(head, k);

            while (ans != null) {
                System.out.print(ans.data + " ");
                ans = ans.next;
            }
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends




/* Link list Node
class Node
{
	Node next;
	int data;
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
class Solution
{
    /*You are required to complete this method*/
    Node deleteK(Node head, int k)
    {
    // Your code here
    if(k==1) return null;
    Node head1=new Node(0);
    Node temp1=head1;
     Node temp=head;
     int x=1;
     while(temp!=null){
         if(x==k){
             temp=temp.next;
             x=1;
         }
        else {
                temp1.next = temp; 
                temp1 = temp1.next; 
                temp = temp.next; 
                x++; 
            }
     }
     temp1.next=null;
     return head1.next;
    }
}