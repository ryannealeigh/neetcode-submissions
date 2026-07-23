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
    public ListNode reverseList(ListNode head) {
        ListNode newList = new ListNode();

        while (head != null) {
            ListNode temp = newList.next;
            newList.next = head;
            head = head.next;
            newList.next.next = temp;
        }
        return newList.next;
    }
}
