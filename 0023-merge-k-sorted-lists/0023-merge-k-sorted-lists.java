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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode result;
        ListNode tmp;
        if (list1.val < list2.val) {
            result = list1;
            tmp = list2;
        } else{
            result = list2;
            tmp = list1;
        }
        ListNode pointer = result;
        while (pointer.next != null && tmp != null){
            if (pointer.next.val > tmp.val){
                ListNode temp = tmp;
                tmp = pointer.next;
                pointer.next = temp;
            }
            pointer = pointer.next;
        }
        pointer.next = tmp;
        return result;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for (ListNode i: lists) {
            if (result == null){
                result = i;
                continue;
            }
            result = mergeTwoLists(result, i);
        }
        return result;
    }
}