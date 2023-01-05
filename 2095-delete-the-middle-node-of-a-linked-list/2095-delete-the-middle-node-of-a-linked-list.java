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
        public ListNode deleteMiddle(ListNode head) {
            if(head.next == null){
                return null;
            }
            ListNode main_pointer = head;
            main_pointer = main_pointer.next;
            ListNode node_pointer = head;
            if(main_pointer.next == null){
                node_pointer.next = node_pointer.next.next;
                return head;
            }
            main_pointer = main_pointer.next;
            boolean counter = true;
            while (main_pointer.next != null){
                main_pointer = main_pointer.next;
                if (counter){
                    node_pointer = node_pointer.next;
                }
                counter = !counter;
            }
            node_pointer.next = node_pointer.next.next;
            return head;
        }
    }