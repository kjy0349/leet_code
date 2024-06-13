class Solution {
    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return ;
        }
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            while (i <= j && nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++; j--;
            }
        }
        swap(nums, left, j);
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }
    
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
}