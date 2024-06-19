class Solution {
    public boolean judgeSquareSum(int c) {
        boolean answer = false;
        for (long i = 0; i * i <= c; i++) {
            long aSquare = i * i;
            double bSquareDouble = Math.sqrt((long)c - aSquare);
            int bSquareInteger = (int)Math.sqrt((long)c - aSquare);
            if (bSquareDouble == bSquareInteger) {
                answer = true;
                break;
            }
        }
        return answer; 
    }
}