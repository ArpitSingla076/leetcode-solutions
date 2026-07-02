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
    public ListNode partition(ListNode head, int x) {
        ListNode temp = head;
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode temp2 = small;
        ListNode temp3 = large;

        while(temp!=null) {
            if(temp.val<x) {
                temp2.next = temp;
                temp = temp.next;
                temp2 = temp2.next;
            }
            else{
                temp3.next = temp;
                temp = temp.next;
                temp3 = temp3.next;
            }
        }
        temp3.next = null;
        temp2.next = large.next;
        return small.next;
    }
}