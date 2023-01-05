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
        public static ListNode swapNodes(ListNode head, int n) {
            ListNode main_pointer = head;
            ListNode second_node_pointer = head;
            ListNode first_node_pointer = head;
            int counter = 0;
            while (main_pointer.next != null){
                main_pointer = main_pointer.next;
                counter ++;
                if (counter >= n){
                    second_node_pointer = second_node_pointer.next;
                }
                if (counter < n){
                    first_node_pointer = first_node_pointer.next;
                }
            }
            int tmp = second_node_pointer.val;
            second_node_pointer.val = first_node_pointer.val;
            first_node_pointer.val = tmp;
            return head;
        }
    }