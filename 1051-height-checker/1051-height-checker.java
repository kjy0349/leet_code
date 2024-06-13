import java.io.*;
import java.util.*;
class Solution {
    static int answer;
    static int[] original;
    
    private void swap(int[] array, int first, int second) {
        int temp = array[second];
        array[second] = array[first];
        array[first] = temp;
    }
    
    private void quickSort(int[] sorted, int leftIdx, int rightIdx) {
        if (leftIdx >= rightIdx) {
            if (leftIdx == rightIdx) {
                if (sorted[leftIdx] != original[leftIdx]) {
                    answer++;
                }
            }
            return ;
        }
        int pivot = sorted[leftIdx];
        int left = leftIdx + 1;
        int right = rightIdx;
        
        while (left <= right) {
            while (left <= right && sorted[left] < pivot) {
                left++;
            }
            while (left <= right && sorted[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(sorted, left, right);
                left++; right--;
            }
        }
        swap(sorted, leftIdx, right);
        if (pivot != original[right]) {
            answer++;
        }
        quickSort(sorted, leftIdx, right - 1);
        quickSort(sorted, right + 1, rightIdx);
    }
    
    public int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        answer = 0;
        original = heights;
        quickSort(sorted, 0, sorted.length - 1);
        // quickSort를 사용한 후, partioning이 수행될 때 마다 heights 배열과 비교하면 더 빨리 답을 구할 수 있을 것.
        return answer;
    }
}