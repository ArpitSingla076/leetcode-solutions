/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        ListNode tempA = headA;
        while(tempA!=null) {
            tempA = tempA.next;
            len1++;
        }

        int len2 = 0;
        ListNode tempB = headB;
        while(tempB!=null) {
            tempB = tempB.next;
            len2++;
        }
        
        tempA = headA;
        tempB = headB;

        if(len1>len2) {
            for(int i=0;i<len1-len2;i++) {
                tempA = tempA.next;
            }
        }
        else{
            for(int i=0;i<len2-len1;i++) {
                tempB = tempB.next;
            }
        }
        while(tempA!=tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}