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
