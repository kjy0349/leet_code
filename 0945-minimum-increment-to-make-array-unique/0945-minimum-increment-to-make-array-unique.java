import java.util.*;
class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            if (set.contains(target)) {
                answer += Math.abs(next + 1 - target);
                target = next + 1;
            }
            next = target;
            set.add(target);
        }
        return answer;
    }
    // 1 1 2 2 3 7
}