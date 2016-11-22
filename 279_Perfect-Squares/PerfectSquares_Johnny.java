/*
 * Time complexity: O(nlogn) ? 
 * Space complexity: O(n) max depth ?
 */
public class Solution {
    private int minDepth = 0;
    public int numSquares(int n) {
        separate(0, n);
        return minDepth;
    }
    
    private void separate(int depth, int n) {
        if (minDepth > 0 && depth >= minDepth) {
            return;
        }
        
        for (int i = (int) Math.sqrt(n); i > 0; i--) {
            int diff = n - i * i;
            
            if (diff == 0) {
                if (minDepth == 0 || depth+1 < minDepth) {
                    minDepth = depth+1;
                }
                return;
            } else if (diff > 0) {
                separate(depth+1, diff);
            }
        }
    }
}