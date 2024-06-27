import java.util.*;
class Solution {
    public static void putToMap(Map<Integer, Integer> target, int node) {
        if (target.containsKey(node)) {
            target.put(node, target.get(node) + 1);
        } else {
            target.put(node, 1);
        }
    }
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> edgeMap = new HashMap<>();
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            putToMap(edgeMap, start);
            putToMap(edgeMap, end);
        }
        TreeSet<Map.Entry<Integer, Integer>> sortedSet = new TreeSet<>((o1, o2) -> { return -Integer.compare(o1.getValue(), o2.getValue());});
        sortedSet.addAll(edgeMap.entrySet());
        return sortedSet.first().getKey();
    }
}