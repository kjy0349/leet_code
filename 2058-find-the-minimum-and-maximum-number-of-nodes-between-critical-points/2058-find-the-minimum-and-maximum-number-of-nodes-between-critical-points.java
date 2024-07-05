/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode rep = head;
        int[] ans = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        List<Integer> critIndices = new ArrayList<>();
        int prev = -1;
        int cnt = 0;
        while (rep.next != null) {
            if (prev != -1) {
                int cur = rep.val;
                if ((cur > prev && cur > rep.next.val) ||
                   (cur < prev && cur < rep.next.val)) {
                    critIndices.add(cnt);
                } 
            }
            prev = rep.val;
            cnt++;
            rep = rep.next;
        }
        for (int i = 0; i < critIndices.size() - 1; i++) {
            int dist = critIndices.get(i + 1) - critIndices.get(i);
            ans[0] = Math.min(dist, ans[0]);
        }
        if (critIndices.size() > 1) {
            ans[1] = critIndices.get(critIndices.size() - 1) - critIndices.get(0);
        }
        if (ans[0] == Integer.MAX_VALUE) {
            ans[0] = -1;
        }
        if (ans[1] == Integer.MIN_VALUE) {
            ans[1] = -1;
        }
        return ans;
    }
}