/*
Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null) {
            ListNode tmp = prev.next;
            ListNode cur = tmp;
            while (cur != null && cur.val == tmp.val) {
                cur = cur.next;
            }
            prev.next = cur;
        }


        ListNode cur = prev.next;

        while (cur != null) {
            ListNode cursor = cur;
            while (cursor != null && cursor.val == cur.val) {
                cursor = cursor.next;
            }
            prev.next = cursor;


            prev = prev.next;
            if (prev != null) {
                cur = prev.next;
            }
        }
        return dummy.next;
    }

}