import java.util.*;
class Solution {
    /*
        가진 capital로 진행할 수 있는 최대 profit을 고르면?
        profit, capital을 가진 class 만들고 (project)
        현재 capital보다 작거나 같은 요구 capital을 가진 project들 중 항상 profit이 최대인 프로젝트를 k개 고르면 된다.
        
    */
    static class Project {
        int profit;
        int capital;
        
        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
        
        @Override
        public String toString() {
            return "profit : " + this.profit + " capital : " + this.capital; 
        }
    }
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> capitalProjects = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.capital, o2.capital);
        });
        for (int i = 0; i < profits.length; i++) {
            capitalProjects.offer(new Project(profits[i], capital[i]));
        }
        PriorityQueue<Project> profitProjects = new PriorityQueue<>((o1, o2) -> {
            return -Integer.compare(o1.profit, o2.profit);
        });
        int currentCapital = w;
        for (int i = 0; i < k; i++) {
            while(!capitalProjects.isEmpty()) {
                Project target = capitalProjects.poll();
                if (target.capital <= currentCapital) {
                    profitProjects.offer(target);
                } else {
                    capitalProjects.offer(target);
                    break;
                }
            }
            if (profitProjects.size() > 0) {
                Project maxProfit = profitProjects.poll();
                currentCapital += maxProfit.profit;
            }
        }
        return currentCapital;
    }
}