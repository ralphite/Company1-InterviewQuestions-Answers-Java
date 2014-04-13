/*
Convert a binary search tree to a doble-linked list. ***
*/

/*
inorder traversal
*/

public class Solution {
    public static DoublyLinkedListNode bst2Dllist(TreeNode root) {
        if(root == null) return null;
        DoublyLinkedListNode node = new DoublyLinkedListNode(root.val);
        if(root.left == null) {
            node.prev = null;
        } else {
            DoublyLinkedListNode p = bst2Dllist(root.left);
            while(p.next != null) {
                p = p.next;
            }
            node.prev = p;
        }
        if(root.right == null) {
            node.next = null;
        } else {
            DoublyLinkedListNode n = bst2Dllist(root.right);
            while(n.prev != null) {
                n = n.prev;
            }
            node.next = n;
        }
        return node;
    }
    public static class DoublyLinkedListNode {
        int val;
        DoublyLinkedListNode prev;
        DoublyLinkedListNode next;
        DoublyLinkedListNode(int v) {
            val = v;
            prev = null;
            next = null;
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
