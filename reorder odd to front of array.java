/**
  Given an interger array, reorder the array to get all the odd interger at the front and all the even number at the end, ***
*/

/*
scan from left for even numbers and from right for odd numbers
swap them till indices meet
*/

public class Solution {
    public static void reorder(int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }
        int i = 0;
        int j = arr.length - 1;
        while(i < j) {
            int leftEven = findNextEven(arr, i);
            int rightOdd = findPrevOdd(arr, j);
            if(leftEven < rightOdd) {
                swap(arr, leftEven, rightOdd);
            }
            i = leftEven + 1;
            j = rightOdd - 1;
        }
    }
    private static int findNextEven(int[] arr, int i) {
        while(i < arr.length) {
            if(arr[i] % 2 == 0) return i;
            else i++;
        }
        return i;
    }
    private static int findPrevOdd(int[] arr, int i) {
        while(i >= 0) {
            if(arr[i] % 2 != 0) {
                return i;
            }
            else {
                i--;
            }
        }
        return i;
    }
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
