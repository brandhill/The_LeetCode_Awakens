

/**
 * Created by hill on 2016/12/12.
 *
 * https://leetcode.com/problems/palindrome-number/
 *
 * Time: O(n)
 * space: O(1)
 *
 */
public class PalindromeNumber_H {

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int rev = 0;

        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;

        }

        return (x == rev || x == rev / 10);
        // 如果是 偶數位數，如 : 1001, 123321 ，用 x == rev 判斷
        // 如果是 奇數位數，如 : 121, 12321 ，用 x == rev / 10 判斷
    }
}
