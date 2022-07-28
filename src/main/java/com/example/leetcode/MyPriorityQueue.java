package com.example.leetcode;

import java.util.Arrays;

public class MyPriorityQueue {
    private int[] elements;
    private int size;

    public MyPriorityQueue() {
        elements = new int[3];
        size = 0;
    }

    public MyPriorityQueue(int[] elems) {
        elements = new int[elems.length];
        for (int i = 0; i < elems.length; i++) {
            elements[i] = elems[i];
        }
        size = elems.length;
        for (int i = size / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    public void offer(int number) {
        if (size == elements.length) {
            int[] newElements = new int[size * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        elements[size] = number;
        size++;
        placeValue(size - 1);
    }

    private void heapify(int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int minIndex;
        if (left < size && elements[left] < elements[index]) {
            minIndex = left;
        } else {
            minIndex = index;
        }
        if (right < size && elements[right] < elements[minIndex]) {
            minIndex = right;
        }
        if (minIndex != index) {
            swap(minIndex, index);
            heapify(minIndex);
        }
    }

    private void placeValue(int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (elements[parent] > elements[index]) {
                swap(parent, index);
                index = parent;
            } else {
                return;
            }
        }
    }

    private void swap(int index1, int index2) {
        int temp = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = temp;
    }

    public boolean remove(int number) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i] == number) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        swap(index, size - 1);
        size--;
        heapify(index);
        return true;
    }

    public int peek() {
        return elements[0];
    }

    public int poll() {
        int res = peek();
        swap(0, size - 1);
        size--;
        heapify(0);
        return res;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        System.out.println(testInit(new int[] { 5, 4, 3, 1, 2 }, new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(testInit(new int[] { 0, 2, 0, 1 }, new int[] { 0, 0, 1, 2 }));
        System.out.println(testOfferAndRemove(new int[] { 5, 4, 3, 1, 2 }, new int[] { 0, 3, 5, 7, 9, 10 }));
    }

    private static boolean testInit(int[] input, int[] expected) {
        MyPriorityQueue queue = new MyPriorityQueue(input);
        int index = 0;
        int[] actual = new int[input.length];
        while (!queue.isEmpty()) {
            actual[index] = queue.poll();
            index++;
        }
        return Arrays.equals(actual, expected);
    }

    private static boolean testOfferAndRemove(int[] input, int[] expected) {
        MyPriorityQueue queue = new MyPriorityQueue(input);
        queue.remove(2);
        queue.poll();
        queue.offer(0);
        queue.offer(7);
        queue.offer(9);
        queue.remove(4);
        queue.offer(10);
        int index = 0;
        int[] actual = new int[expected.length];
        while (!queue.isEmpty()) {
            actual[index] = queue.poll();
            index++;
        }
        return Arrays.equals(actual, expected);
    }
}
