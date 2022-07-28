package com.example.leetcode;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = solution.buildTree(new int[]{9, 3, 15, 20, 7},
             new int[]{9, 15, 7, 20, 3});
        System.out.println(node);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int[] postorder, int left, int right, int poRight) {
        if (poRight < 0 || left > right) {
            return null;
        }
        int poElem = postorder[poRight];
        int inElemIndex = -1;
        for (int i = left; i <= right; i++) {
            if (poElem == inorder[i]) {
                inElemIndex = i;
                break;
            }
        }
        TreeNode node = new TreeNode(poElem);
        node.right = buildTree(inorder, postorder, inElemIndex + 1, right, poRight - 1);
        node.left = buildTree(inorder, postorder, left, inElemIndex - 1, poRight - (right - inElemIndex) - 1);
        return node;
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
}