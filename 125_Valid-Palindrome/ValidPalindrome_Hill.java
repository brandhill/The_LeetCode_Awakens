/*

Time : O(n)
Space : O(1)

 */


public class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            while (i < s.length() - 1 && !isAlpha(s.charAt(i)) && !isNum(s.charAt(i))) {
                i++;
            }

            while (j > 0 && !isAlpha(s.charAt(j)) && !isNum(s.charAt(j))) {
                j--;
            }

            if (i >= j) {
                break;
            }

            if (s.charAt(j) != s.charAt(i)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }


    private boolean isAlpha(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        } else {
            return false;
        }

    }

    private boolean isNum(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }
}
