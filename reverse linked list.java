/**
Reverse a linked list. *
*/

/*
method 1: O(n) O(n)
scan list, each node push to stack
create dummy node, link all nodes
popped from stack
return dummy.next

method 2: O(n) O(1)
create dummy node dummy
node = head
while node:
    oldNodeNext = node.next
    oldDummyNext = dummy.next
    dummy.next = node
    node.next = oldDummyNext
    node = oldNodeNext
*/

public class Solution {
    public void reverseListNode2(ListNode head) {
        //if(head == null) return;
        ListNode dummy = new ListNode();
        while(head != null) {
            ListNode oldHeadNext = head.next;
            ListNode oldDummyNext = dummy.next;
            dummy.next = head;
            head.next = oldDummyNext;
            head = oldHeadNext;
        }
    }
}
