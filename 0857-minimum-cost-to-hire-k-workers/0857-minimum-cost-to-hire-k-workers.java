import java.util.*;
class Solution {
    static class Pair {
        int quality;
        int wage;
        Pair(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
        }
        @Override
        public String toString() {
            return "quality : " + quality + " wage : " + wage;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        PriorityQueue<Pair> candidates = new PriorityQueue<>((p1, p2) -> {
            /* 
                가성비 순으로 정렬. 가성비가 좋은 후보자부터 넣어야 최소 지불 가능
                가성비가 같다면, quality가 낮은 사람(돈을 덜 줘도 되는 사람)을 먼저 고용할 것.
                -> 같을 때 quality가 낮은 사람을 뽑아 줄 필요도 없다. 어차피 밑에서 quality 높은 사람을 먼저 쫓아내기 때문.
            */
            return Double.compare((double)p1.wage / p1.quality, (double)p2.wage / p2.quality);
            // int compare = Double.compare((double)p1.wage / p1.quality, (double)p2.wage / p2.quality);
            // if (compare == 0) {
            //     return Integer.compare(p1.quality, p2.quality);
            // } else {
            //     return compare;
            // }
        });
        for (int i = 0; i < quality.length; i++) {
            candidates.offer(new Pair(quality[i], wage[i]));
        }
        /*
            계속해서 가성비가 안 좋은 사람들이 들어올 것. 따라서, 지불해야 하는 퀄리티 당 임금은 계속해서 높은 값이 된다.
            이 상황에서 임금을 줄이기 위해서는, quality가 좋은 사람들을 계속 내보내면 됨. 어차피 지불해야 할 임금은 고정이고, quality를 배수로 주기 때문.
            여기서는 정렬기준인 quality가 같다고해도 사실 별 상관 없다. 어차피 지불해야 할 임금은 같기 때문. quality가 낮은 사람을 내보낸다고 해도, 어차피 지불해야 할 quality당 임금은 동일.
        */
        PriorityQueue<Pair> employee = new PriorityQueue<>((e1, e2) -> {
            return -Integer.compare(e1.quality, e2.quality);
        });
        int sumQuality = 0;
        Pair maxPayRate = new Pair(1, 0);
        double answer = Double.MAX_VALUE;
        while (!candidates.isEmpty()) {
            if (employee.size() != k) {
                Pair target = candidates.poll();
                System.out.println(target);
                if ((double)maxPayRate.wage / maxPayRate.quality < (double)target.wage / target.quality) {
                    maxPayRate = target;
                }
                employee.offer(target);
                sumQuality += target.quality;
            } else if (employee.size() == k) {
                Pair target = employee.poll();
                answer = Double.min(answer, (double)sumQuality / maxPayRate.quality * maxPayRate.wage);
                sumQuality -= target.quality;
            }
        }
        answer = Double.min(answer, (double)sumQuality / maxPayRate.quality * maxPayRate.wage);
        return answer;
    }
}