public class Solution {
    public int numDecodings(String s) {
        char[] input = s.toCharArray();
        if(input.length == 0 || ctoi(input[0]) == 0)
            return 0;

        int[] dp = new int[input.length+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=1; i<input.length; i++) {
            int prev = ctoi(input[i-1]);
            int curr = ctoi(input[i]);
            int val = 10 * prev + curr;
            
            if(curr == 0 && (prev == 0  || val > 26)) return 0;
            
            dp[i+1] = (curr != 0 ? dp[i] : 0) + ((prev != 0 && val <= 26) ? dp[i-1] : 0);
        }
        
        return dp[input.length];
    }
    
    int ctoi(char c) {
        return c-'0';
    }
}
