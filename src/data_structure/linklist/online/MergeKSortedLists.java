package data_structure.linklist.online;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MergeKSortedLists mks = new MergeKSortedLists();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, new ListNode(4));
        mks.mergeKListsPQ(new ListNode[]{l1});
    }


    public ListNode mergeKListsPQ(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (null != list) minHeap.add(list);
        }
        if (minHeap.isEmpty()) return null;
        ListNode dummy = new ListNode(-1), prev = dummy;
        while (!minHeap.isEmpty()) {
            prev.next = minHeap.poll();
            prev = prev.next;
            if (prev.next != null) {
                minHeap.add(prev.next);
            }
        }
        return dummy.next;
    }


    /**
     * complexity
     * Time complexity : O(kN)
     * Space complexity : O(1)
     */


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for (ListNode list : lists) {
            head = mergeTwoLists(head, list);
        }
        return head;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head3 = null;
        if (l1.val <= l2.val) {
            head3 = l1;
            l1 = l1.next;
        } else {
            head3 = l2;
            l2 = l2.next;
        }
        ListNode current = head3;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 == null) {
            current.next = l2;
        } else {
            current.next = l1;
        }
        return head3;
    }
}
