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
    public ListNode findNthNode(ListNode head,int n) {
        ListNode temp = head;
        for(int i=1;i<n;i++) {
            temp = temp.next;
        }
        return temp;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode tail = head;
        int len = 1;
        while(tail.next!=null) {
            len++;
            tail = tail.next;
        }
        if(k%len==0) return head;
        k=k%len;
        tail.next = head;

        ListNode newLastnode = findNthNode(head,len-k);
        head = newLastnode.next;
        newLastnode.next = null;
        return head;
    }
}