/*
Give a linked list, reversly output all the values of the linked list.**
*/

import java.util.Stack;

public class Solution {
    public static void reversePrint(ListNode node) {
        if(node == null) return;
        Stack<Integer> stack = new Stack<Integer>();
        while(node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) {
            val = v;
            next = null;
        }
    }
}
