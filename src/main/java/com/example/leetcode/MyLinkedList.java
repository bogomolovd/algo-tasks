package com.example.leetcode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.StringJoiner;

class MyLinkedList {
    private Node head;
    private int length;

    public MyLinkedList() {

    }

    public int get(int index) {
        Node node = getNodeAtIndex(index);
        return node == null ? -1 : node.val;
    }

    private Node getNodeAtIndex(int index) {
        if (head == null || index < 0) {
            return null;
        }
        Node node = head;
        for (int i = 1; i <= index; i++) {
            node = node.next;
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        length++;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(val);
            length++;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index > length || index < 0) {
            return;
        } else if (index == length) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else {
            Node prev = getNodeAtIndex(index - 1);
            if (prev == null) {
                return;
            }
            Node node = new Node(val);
            node.next = prev.next;
            prev.next = node;
            length++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index > length || index < 0) {
            return;
        } else if (index == 0) {
            head = head.next;
            length--;
        } else {
            Node prev = getNodeAtIndex(index - 1);
            if (prev == null) {
                return;
            }
            Node node = prev.next;
            if (node == null) {
                return;
            }
            prev.next = node.next;
            length--;
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        Node node = head;
        int index = 0;
        while (node != null) {
            joiner.add(index + "=" + node.val);
            node = node.next;
            index++;
        }
        return joiner.toString();
    }

    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private static class Solution {
        public static void main(String[] args) {
            MyLinkedList myLinkedList = new MyLinkedList();
            String[] ops = new String[] { "addAtHead", "addAtTail", "addAtTail", "addAtTail",
                    "addAtTail", "addAtTail",
                    "addAtTail", "deleteAtIndex", "addAtHead", "addAtHead", "get", "addAtTail", "addAtHead", "get",
                    "addAtTail", "addAtIndex",
                    "addAtTail", "addAtHead", "addAtHead", "addAtHead", "get", "addAtIndex", "addAtHead", "get",
                    "addAtHead", "deleteAtIndex",
                    "addAtHead", "addAtTail", "addAtTail", "addAtIndex", "addAtTail", "addAtHead", "get", "addAtTail",
                    "deleteAtIndex", "addAtIndex",
                    "deleteAtIndex", "addAtHead", "addAtTail", "addAtHead", "addAtHead", "addAtTail", "addAtTail",
                    "get", "get", "addAtHead", "addAtTail",
                    "addAtTail", "addAtTail", "addAtIndex", "get", "addAtHead", "addAtIndex", "addAtHead", "addAtTail",
                    "addAtTail", "addAtIndex",
                    "deleteAtIndex", "addAtIndex", "addAtHead", "addAtHead", "deleteAtIndex", "addAtTail",
                    "deleteAtIndex", "addAtIndex", "addAtTail",
                    "addAtHead", "get", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "addAtHead", "addAtHead",
                    "addAtHead", "addAtHead",
                    "deleteAtIndex", "get", "get", "addAtHead", "get", "addAtTail", "addAtTail", "addAtIndex",
                    "addAtIndex", "addAtHead", "addAtTail",
                    "addAtTail", "get", "addAtIndex", "addAtHead", "deleteAtIndex", "addAtTail", "get", "addAtHead",
                    "get", "addAtHead", "deleteAtIndex",
                    "get", "addAtTail", "addAtTail" };
            int[][] opsArgs = new int[][] { { 38 }, { 66 }, { 61 }, { 76 }, { 26 }, { 37 }, { 8 }, { 5 }, { 4 },
                    { 45 }, { 4 }, { 85 }, { 37 }, { 5 }, { 93 }, { 10, 23 }, { 21 }, { 52 }, { 15 },
                    { 47 }, { 12 }, { 6, 24 }, { 64 }, { 4 }, { 31 }, { 6 }, { 40 }, { 17 }, { 15 }, { 19, 2 }, { 11 },
                    { 86 }, { 17 }, { 55 }, { 15 }, { 14, 95 }, { 22 }, { 66 }, { 95 }, { 8 }, { 47 }, { 23 },
                    { 39 }, { 30 }, { 27 }, { 0 }, { 99 }, { 45 }, { 4 }, { 9, 11 }, { 6 }, { 81 }, { 18, 32 }, { 20 },
                    { 13 }, { 42 }, { 37, 91 }, { 36 }, { 10, 37 }, { 96 }, { 57 }, { 20 }, { 89 }, { 18 },
                    { 41, 5 }, { 23 }, { 75 }, { 7 }, { 25, 51 }, { 48 }, { 46 }, { 29 }, { 85 }, { 82 }, { 6 }, { 38 },
                    { 14 }, { 1 }, { 12 }, { 42 }, { 42 }, { 83 }, { 13 }, { 14, 20 }, { 17, 34 }, { 36 },
                    { 58 }, { 2 }, { 38 }, { 33, 59 }, { 37 }, { 15 }, { 64 }, { 56 }, { 0 }, { 40 }, { 92 }, { 63 },
                    { 35 }, { 62 }, { 32 } };
            Class<MyLinkedList> clazz = MyLinkedList.class;
            for (int i = 0; i < ops.length; i++) {
                Method method = findMethodByName(clazz, ops[i]);
                Object[] argsForOp = convert(opsArgs[i]);
                try {
                    method.invoke(myLinkedList, argsForOp);
                    System.out.println("N=" + i + " op=" + ops[i] + " args=" + Arrays.toString(opsArgs[i]) + " list=" + myLinkedList.toString());
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        private static Method findMethodByName(Class<?> clazz, String name) {
            return Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.getName().equals(name))
                .findAny()
                .orElse(null);
        }

        private static Object[] convert(int[] args) {
            Object[] res = new Object[args.length];
            for (int i = 0; i < args.length; i++) {
                res[i] = (Integer) args[i];
            }
            return res;
        }
    }
}