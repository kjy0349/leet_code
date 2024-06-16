class Solution {
    /*
        nums는 오름차순으로 정렬되어 있다. 1~n까지의 수를 nums의 부분집합의 합으로 표현해야하는데, 이 때 주어진 nums만으로는 불가능할 수 있다. 가능하다면 0을, 불가능하다면 어떤 숫자를 추가해야 1~n까지의 수를 부분집합의 합으로 표현할 수 있을까? 가능한 숫자들의 개수를 최소로 할 때, 해당 개수를 출력하시오.
    */
    public int minPatches(int[] nums, int n) {
        int answer = 0;
        long poss = 1;
        int i = 0;
        while (poss <= n) {
            if (i < nums.length && nums[i] <= poss) {
                poss += nums[i++];
            } else {
                answer++;
                poss += poss;
            }
        }
        return answer;
    }
}