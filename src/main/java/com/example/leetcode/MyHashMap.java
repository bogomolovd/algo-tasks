package com.example.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class MyHashMap {
    private static float LOAD_FACTOR = 0.75f;
    private BST[] buckets;
    private int length;
    
    public MyHashMap() {
        buckets = new BST[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new BST();
        }
    }
    
    public void put(int key, int value) {
        int hash = hash(key);
        buckets[hash].put(key, value);
        if (length > buckets.length * LOAD_FACTOR) {
            rehash();
        }
    }
    
    private int hash(int key) {
        return key % buckets.length;
    }

    private void rehash() {
        BST[] oldBuckets = buckets;
        buckets = new BST[oldBuckets.length * 2];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new BST();
        }
        length = 0;
        for (BST oldBucket : oldBuckets) {
            for (Node node : oldBucket.elements()) {
                put(node.key, node.val);
            }
        }
    }
     
    public int get(int key) {
        int hash = hash(key);
        return buckets[hash].get(key);
    }
    
    public void remove(int key) {
        int hash = hash(key);
        buckets[hash].remove(key);
    }
    
    private class BST {
        Node root;
        
        public void put(int key, int val) {
            if (root == null) {
                root = new Node(key, val);
                length++;
                return;
            }
            Node cur = root;
            while (cur != null) {
                if (cur.key == key) {
                    cur.val = val;
                    return;
                } else if (cur.key > key) {
                    if (cur.left != null) {
                        cur = cur.left;    
                    } else {
                        cur.left = new Node(key, val);
                        length++;
                        return;
                    }
                } else {
                    if (cur.right != null) {
                        cur = cur.right;    
                    } else {
                        cur.right = new Node(key, val);
                        length++;
                        return;
                    }
                }
            }
        }

        public int get(int key) {
            Node cur = root;
            while (cur != null) {
                if (cur.key == key) {
                    return cur.val;
                } else if (cur.key > key) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
            return -1;
        }

        public void remove(int key) {
            root = removeInternal(root, key);
        }

        private Node removeInternal(Node node, int key) {
            if (node == null) {
                return null;
            }
            if (node.key == key) {
                if (node.left == null && node.right == null) {
                    length--;
                    return null;
                } else if (node.left != null && node.right == null) {
                    length--;
                    return node.left;
                } else if (node.left == null && node.right != null) {
                    length--;
                    return node.right;
                } else {
                    Node succ = node.right;
                    while (succ.left != null) {
                        succ = succ.left;
                    }
                    node.key = succ.key;
                    node.val = succ.val;
                    node.right = removeInternal(node.right, succ.key);
                    return node;
                }
            } else if (node.key > key) {
                node.left = removeInternal(node.left, key);
                return node;
            } else {
                node.right = removeInternal(node.right, key);
                return node;
            }
        }

        public List<Node> elements() {
            List<Node> elements = new LinkedList<>();
            Stack<Node> stack = new Stack<>();
            Node node = root;
            while (node != null || !stack.empty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                elements.add(node);
                node = node.right;
            }
            return elements;
        }
    }
    
    private class Node {
        Node left;
        Node right;
        int key;
        int val;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}