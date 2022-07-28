package com.example.leetcode;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode fifth = new ListNode(5, null);
        ListNode fourth = new ListNode(4, fifth);
        ListNode third = new ListNode(3, fourth);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(1, second);
        Solution solution = new Solution();
        System.out.println(solution.oddEvenList(first));
    }


    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            ListNode oddHead = null;
            ListNode oddTail = null;
            ListNode evenHead = null;
            ListNode evenTail = null;
            ListNode node = head;
            int index = 1;
            while (node != null) {
                if (index % 2 != 0) {
                    if (oddHead == null) {
                        oddHead = node;
                        oddTail = node;
                    } else {
                        oddTail.next = node;
                        oddTail = node;
                    }
                } else {
                    if (evenHead == null) {
                        evenHead = node;
                        evenTail = node;
                    } else {
                        evenTail.next = node;
                        evenTail = node;
                    }
                }
                node = node.next;
            }
            if (oddTail != null) {
                oddTail.next = evenHead;
                return oddHead;
            } else {
                return evenHead;
            }
        }
    }

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
}
