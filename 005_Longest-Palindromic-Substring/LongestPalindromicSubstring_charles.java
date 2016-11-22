/*
	Author: Charles Tsai
	
	My solution  is trying to traverse the center of palindrome sequentially. Once traverse to a character, check if it's left and rigtht one is equivalent or not, and then increment the count.
	Note that we should split odd and even case respectively.
	
*/
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null) throw new IllegalArgumentException("input is null");
        if (s.isEmpty()) return s;
        char[] charArray = s.toCharArray();
        int maxLength = 0;
        int palindromeIndex = 0;

        for (int i = 0; i < charArray.length; ++i) {
            int countOdd = 0;
            while(i - countOdd >= 0 && i + countOdd < s.length()) {
                if (charArray[i - countOdd] != charArray[i + countOdd]) {
                    break;
                } else {
                    ++countOdd;
                }
            }
            // adjust count to real length
            --countOdd;
            countOdd = 2 * countOdd + 1;

            int countEven = 0;
            while(i - countEven >= 0 && i + countEven + 1 < s.length()) {
                if (charArray[i - countEven] == charArray[i + countEven + 1]) {
                    ++countEven;
                } else {
                    break;
                }
            }
            // adjust count to real length
            countEven = 2 * countEven;

            //System.out.println("i=" + i + " countOdd=" + countOdd + " countEven=" + countEven);

            if (countEven > countOdd) {
                if (maxLength < countEven) {
                    maxLength = countEven;
                    palindromeIndex = i;
                }
            } else {
                if (maxLength == 0 && countOdd == 1) {
                    maxLength = countOdd;
                    palindromeIndex = i;
                } else if (maxLength < countOdd) {
                    maxLength = countOdd;
                    palindromeIndex = i;
                }
            }
        }

        int beginIndex = (maxLength%2 == 0) ? (palindromeIndex - maxLength/2 + 1) : (palindromeIndex - maxLength/2);
        int endIndex = beginIndex + maxLength;

        //System.out.println("p=" + palindromeIndex + " " + charArray[palindromeIndex] + ", m=" + maxLength + " b=" + beginIndex + " e=" + endIndex);

        return s.substring(beginIndex, endIndex);
    }
}


/*
	Use DP to solve this. It can be initialized with length = 1 and length = 2.
 */
 public class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        int max = 1;
        int start = 0, end = 0;
        
        for(int i = 0; i < n; i++)
        {
            dp[i][i] = true;
        }
        
        for(int i = 0; i < n - 1; i++)
        {
            if(s.charAt(i) == s.charAt(i + 1))
            {
                dp[i][i + 1] = true;
                max = 2;
                start = i;
                end = i + 1;
            }
            else
            {
                dp[i][i + 1] = false;
            }
        }
        
        for(int k = 3; k <= n; k++)
        {
            for(int i = 0; i < n - k + 1; i++)
            {
                int j = i + k - 1;
                
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                if(dp[i][j])
                {
                    if(k > max)
                    {
                        max = k;
                        start = i;
                        end = j;
                    }
                }
                
            }
        }
        
        return s.substring(start, end + 1);
        
    }
}