package com.sv.leetcode123.theLeecodeAwakens;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by hill on 2016/11/28.
 */
public class WordBreak {


    // Time: Time Limit Exceeded
    // O(n^2), n is the length of string s.
    // Space: O(1)
    private boolean wordBreakHelper(String s, Set<String> dict, int start) {

        for (String wordInDict : dict) {

            int len = wordInDict.length();
            int end = start + len;

            // out of bound, next
            if (len > s.length()) {
                continue;
            }

            if (s.substring(start, end).equals(wordInDict)) {

                if (end == s.length()) {
                    return true;
                }

                if (wordBreakHelper(s, dict, end)) {
                    return true;
                }
            }
        }

        return false;
    }


    // array t if t[i] is true >>  0 ~ i -1 is a word in dict.
    // Time : O(n * m), n is the length of string s, and m is the size of dictionary
    // Space : O(n)
    public static boolean wordBreakByDP(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length() + 1];
        Arrays.fill(t, false);
        t[0] = true; //we need initial state, so set first to be true

        for (int i = 0; i < s.length(); i++) {
            //should continue from match position
            if (!t[i]) {
                continue;
            }

            for (String wordInDict : dict) {
                int len = wordInDict.length();
                int end = i + len;
                if (end > s.length()) {
                    continue;
                }

                if (t[end]) {
                    continue;
                }

                if (s.substring(i, end).equals(wordInDict)) {
                    t[end] = true;
                }
            }
        }

        System.out.println("array t : " + Arrays.toString(t));


        return t[s.length()];
    }


}
