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
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode main_pointer = head;
            ListNode delited_node_pointer = head;
            ListNode prev_node_pointer = head;
            int counter = 0;
            while (main_pointer.next != null){
                main_pointer = main_pointer.next;
                counter ++;
                if (counter >= n){
                    delited_node_pointer = delited_node_pointer.next;
                }
                if (counter > n){
                    prev_node_pointer = prev_node_pointer.next;
                }
            }
            if (delited_node_pointer == head) {
                return head.next;
            }
                prev_node_pointer.next = delited_node_pointer.next;
            return head;
        }
    }