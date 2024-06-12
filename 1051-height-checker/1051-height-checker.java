import java.io.*;
import java.util.*;
class Solution {
    private int getDiffCount(int[] target, int[] sorted) throws IllegalArgumentException{
        if (target.length != sorted.length) {
            throw new IllegalArgumentException("Invalid Input for arrays.");
        }
        int diffCount = 0;
        for (int i = 0; i < target.length; i++) {
            if (target[i] != sorted[i]) {
                diffCount++;
            }
        }
        return diffCount;
    }
    
//     private void swap(int[] array, int first, int second) {
//         int temp = array[second];
//         array[second] = array[first];
//         array[first] = temp;
//     }
    
//     private void quickSort(int[] sorted, int leftIdx, int rightIdx) {
//         if (leftIdx >= rightIdx) {
//             return ;
//         }
//         int pivot = leftIdx;
//         int left = leftIdx;
//         int right = rightIdx;
//         while (left < right) {
//             while (sorted[left] < sorted[pivot]) {
//                 left++;
//             }
//             while (sorted[right] > sorted[pivot]) {
//                 right--;
//             }
//             if (left < right) {
//                 swap(sorted, left, right);
//             }
//         }
//         swap(sorted, pivot, right);
//         quickSort(sorted, leftIdx, pivot - 1);
//         quickSort(sorted, pivot + 1, rightIdx);
//     }
    
    public int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        // quickSort(sorted, 0, sorted.length - 1);
        Arrays.sort(sorted);
        int answer = getDiffCount(heights, sorted);
        return answer;
    }
}