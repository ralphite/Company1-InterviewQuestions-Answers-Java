/**
possible stack output of push order.java

Give two interger sequence. One is the push order of the stack, 
judge whether another sequence could be the output of the stack. 
For example, push(1,2,3,4,5), then *(4,5,3,2,1) could be but 
(4,3,5,1,2) could not be.****
*/

/*
this algorithm only works if all integers are unique

say output is n1, n2, n3, n4...n(i-1), ni
remove n1
for all numbers before n1 in input, these numbers should be
in reversed order in output
for all numbers after n1 in input they become a smaller question

 T(n) = T(n-k) + O(n)
 worst time complexity is O(n^2)

*/
import java.util.HashSet;
import java.util.Arrays;

public class Solution {
    public boolean isPossibleOutput(int[] A, int[] B) {
        if(A == null || B == null || A.length != B.length) return false;
        int index = Arrays.binarySearch(B[0]);
        if(index < 0) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < index; i++) set.add(A[i]);
        int[] newB = new int[B.length - 1 - index];
        int j = 0;
        int k = index - 1;
        for(int i = 0; i < B.length; i++) {
            if(!set.contains(B[i])) newB[j++] = B[i];
            else {
                if(B[i] != A[k--]) return false;
            } 
        }
        return isPossibleOuput(Arrays.copyOfRange(A, index + 1, A.length), newB);
    }
}
