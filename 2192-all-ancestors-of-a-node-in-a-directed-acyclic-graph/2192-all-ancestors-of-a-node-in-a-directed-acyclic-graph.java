import java.util.*;
class Solution {
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adjList, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        queue.offer(start);
        set.add(start);
        while (!queue.isEmpty()) {
            int target = queue.poll();
            for (int elem : adjList.get(target)) {
                if (!set.contains(elem)) {
                    set.add(elem);
                    queue.offer(elem);
                }
            }
        }
        for (int elem : set) {
            if (elem != start) {
                ans.add(elem);
            }
        }
        return ans;
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            adjList.get(end).add(start);
        }
        for (int i = 0; i < n; i++) {
            answer.add(bfs(adjList, i));
        }
        return answer;
    }
}