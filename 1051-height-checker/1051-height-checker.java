import java.io.*;
import java.util.*;
class Solution {
    int answer;
    int[] original;
    
    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            if (left == right) {
                if (original[left] != array[left]) {
                    answer++;
                }
            }
            return ;
        }
        int pivot = array[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && pivot > array[i]) {
                i++;
            }
            while (i <= j && pivot < array[j]) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        swap(array, left, j);
        if (pivot != original[j]) {
            answer++;
        }
        quickSort(array, left, j - 1);
        quickSort(array, j + 1, right);
    }
    
    public int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        answer = 0;
        original = heights;
        
        quickSort(sorted, 0, sorted.length - 1);
        System.out.println(Arrays.toString(sorted));
        // quickSort를 사용한 후, partioning이 수행될 때 마다 heights 배열과 비교하면 더 빨리 답을 구할 수 있을 것.
        return answer;
    }
}