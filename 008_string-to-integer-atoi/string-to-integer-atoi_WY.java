public class Solution {
    public int myAtoi(String str) {
        int sign = 1;
        int sum = 0;
        boolean isOverflow = false;
        boolean isStart = false;
        for(int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);
            if(curr == '+' && !isStart) {
                isStart = true;
                sign = 1;
            } else if(curr == '-' && !isStart) {
                isStart = true;
                sign = -1;
            } else if(curr == ' ' && !isStart) {
                //skip
            } else if(curr >= '0' && curr <= '9') {
                isStart = true;
                
                if(sum > (Integer.MAX_VALUE-(curr - '0')) / 10) {
                    isOverflow = true;
                    break;
                }
                sum = sum * 10 + (curr - '0');
            } else {
                break;
            }
        }
        if(isOverflow) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return sign * sum;
    }
}
