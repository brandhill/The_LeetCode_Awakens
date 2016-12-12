package com.sv.leetcode123.theLeecodeAwakens;

import com.sv.leetcode123.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hill on 11/12/2016.
 * <p>
 * https://leetcode.com/problems/decode-ways/
 * <p>
 * https://discuss.leetcode.com/topic/35840/java-clean-dp-solution-with-explanation
 * <p>
 * I used a dp array of size n + 1 to save subproblem solutions.
 * dp[0] means an empty string will have one way to decode,
 * dp[1] means the way to decode a string of size 1.
 * <p>
 * I then check one digit and two digit combination
 * and save the results along the way.
 * In the end, dp[n] will be the end result.
 * <p>
 * <p>
 * Time : O(n)
 * Space : O(n)
 */
public class DecodeWays {

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;  //dp[0] means an empty string will have one way to decode
        dp[1] = s.charAt(0) != '0' ? 1 : 0;  //dp[1] means the way to decode a string of size 1.
        // If the char in string[0] is 0, it can't be decoded, value would be 0.

        for (int i = 2; i <= len; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));

            if (first >= 1 && first <= 9) {
                Utils.log("in 1 ~ 9, add " + first);
                dp[i] += dp[i - 1];

            }
            if (second >= 10 && second <= 26) {
                Utils.log("in 10 ~ 26, add " + second);
                dp[i] += dp[i - 2];
            }

        }

        return dp[n];
    }
}
