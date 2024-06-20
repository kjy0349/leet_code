import java.util.*;
class Solution {
    /*
        difficulty, profit은 i번째 일의 난이도와 이익.
        worker는 j번째 노동자의 능력. 능력은 난이도와 같음.
        
        모든 작업자는 최대 하나의 일만 맡을 수 있다. 반면에 하나의 일은 여러번 완료될 수 있음.(반복 가능)
        이 때 얻을 수 있는 최대 이익을 출력하시오.
    */
    static class Job {
        int difficulty;
        int profit;
        
        Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
    
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<Job> jobs = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.difficulty, o2.difficulty));
        PriorityQueue<Job> possJobs = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1.profit, o2.profit));
        for (int i = 0; i < difficulty.length; i++) {
            jobs.offer(new Job(difficulty[i], profit[i]));
        }
        Arrays.sort(worker);
        int answer = 0;
        for (int i = 0; i < worker.length; i++) {
            int ability = worker[i];
            while (!jobs.isEmpty()) {
                Job target = jobs.poll();
                if (target.difficulty <= ability) {
                    possJobs.offer(target);
                } else {
                    jobs.offer(target);
                    break;
                }
            }
            if (!possJobs.isEmpty()) {
                answer += possJobs.peek().profit;
            }
        }
        return answer;
    }
}