/*
Give a binary tree, output it’s mirror tree. Using recurtion and also looping. ***
*/

/*
recursive:
mirror(t):
    if !t:
        return
    mirror(t.left)
    mirror(t.right)
    swap t.left, t.right

iterative:
mirror(t):
    if !t:
        return
    q.add(t)
    while q:
        tr=q.poll
        if tr.left:
            q.add tr.left
        if tr.right:
            q.add tr.right
        swap tr.left, tr.right
*/
import java.util.LinkedList;

public class Solution {
    public static void mirrorRecursive(TreeNode t) {
        if(t == null) return;
        mirrorRecursive(t.left);
        mirrorRecursive(t.right);
        //swap(t.left, t.right); Java is always pass-by-value.
        //so swap doesnt work
        TreeNode temp = t.left;
        t.left = t.right;
        t.right = temp;
    }
    public static void mirrorIterative(TreeNode t) {
        if(t == null) return;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(t);
        while(!q.isEmpty()) {
            TreeNode tr = q.poll();
            if(tr.left != null) q.add(tr.left);
            if(tr.right != null) q.add(tr.right);
            TreeNode temp = tr.left;
            tr.left = tr.right;
            tr.right = temp;
        }
    }
}
