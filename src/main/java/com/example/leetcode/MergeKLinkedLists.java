package com.example.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class MergeKLinkedLists {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode resultHead = null;
            ListNode resultTail = null;
            PriorityQueue<ListNode> queue = new PriorityQueue<>(10000,
                 Comparator.comparingInt(n -> n.val));
            for (int i = 0; i < lists.length; i++) {
                ListNode curNode = lists[i];
                if (curNode != null) {
                    queue.offer(curNode);
                }
            }
            while (!queue.isEmpty()) {
                ListNode min = queue.poll();
                ListNode newNode = new ListNode(min.val);
                if (resultHead == null) {
                    resultHead = newNode;
                    resultTail = newNode;
                } else {
                    resultTail.next = newNode;
                    resultTail = newNode;
                }
                min = min.next;
                if (min != null) {
                    queue.offer(min);
                }
            }
            return resultHead;
        }
    }

    public class ListNode {
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
}