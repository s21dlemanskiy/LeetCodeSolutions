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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int memory = 0;
            ListNode result = new ListNode();
            ListNode tail = result;

            while(true){
                memory = l1.val + l2.val + memory;
                tail.val = memory % 10;
                memory = memory / 10;
                if (l1.next != null && l2.next != null) {
                    l1 = l1.next;
                    l2 = l2.next;
                    tail.next = new ListNode();
                    tail = tail.next;
                }else{
                    break;
                }
            }
            boolean continue_suming = false;
            if (l1.next == null){
                l1 = l2;
            }
            if (l1.next != null){
                tail.next = new ListNode();
                tail = tail.next;
                l1 = l1.next;
                continue_suming = true;
            }
            while (continue_suming){
                memory = l1.val + memory;
                tail.val = memory % 10;
                memory = memory / 10;
                if(l1.next != null) {
                    tail.next = new ListNode();
                    tail = tail.next;
                    l1 = l1.next;
                }else{
                    break;
                }
            }
            if (memory != 0){
                tail.next = new ListNode();
                tail = tail.next;
                tail.val = memory;

            }
            return result;
        }
}