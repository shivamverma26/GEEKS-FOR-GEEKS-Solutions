//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public List<Integer> findMajority(List<Integer> nums) {
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MAX_VALUE;
        int cnt1 = 0, cnt2 = 0;
        int n = nums.size();

        for (int num : nums) {
            if (cnt1 == 0 && ele2 != num) {
                cnt1++;
                ele1 = num;
            } else if (cnt2 == 0 && ele1 != num) {
                cnt2++;
                ele2 = num;
            } else if (ele1 == num) {
                cnt1++;
            } else if (ele2 == num) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == ele1) cnt1++;
            if (num == ele2) cnt2++;
        }

        List<Integer> ans = new ArrayList<>();
        if (cnt1 > n / 3) ans.add(ele1);
        if (cnt2 > n / 3) ans.add(ele2);
        if (ans.isEmpty()) ans.add(-1);

        return ans;
    }
}
