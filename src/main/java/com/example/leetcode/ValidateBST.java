package com.example.leetcode;

public class ValidateBST {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1, null, null);
        TreeNode three = new TreeNode(3, null, null);
        TreeNode six = new TreeNode(6, null, null);
        TreeNode four = new TreeNode(4, three, six);
        TreeNode five = new TreeNode(5, one, four);
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(five));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, new Box());
        }
        
        private boolean isValidBST(TreeNode node, Box prevVal) {
            if (node.left != null && !isValidBST(node.left, prevVal)) {
                return false;
            }
            Integer prevElem = prevVal.val;
            if (prevElem != null && prevElem >= node.val) {
                return false;
            } else {
                prevVal.val = node.val;    
            }
            if (node.right != null && !isValidBST(node.right, prevVal)) {
                return false;
            }
            return true;
        }
    }

    static class Box {
        Integer val;
    }
}
