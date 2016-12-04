public class Solution {
  //Solution 1:
  public boolean isPalindrome(String s) {
	int len = null != s ? s.length() : 0;
	if (len < 0) {
	  return false;
	}
	int sIdx = 0, eIdx = len - 1;
	while(sIdx < eIdx) {
	  if (!Character.isLetterOrDigit(s.charAt(sIdx))) {
		sIdx++;
	  } else if (!Character.isLetterOrDigit(s.charAt(eIdx))) {
		eIdx--;
	  } else {
		if (Character.toLowerCase(s.charAt(sIdx)) != Character.toLowerCase(s.charAt(eIdx))) {
		  return false;
		}
		sIdx++;
		eIdx--;
	  }
	}
	return true;
  }
  // Solution 2:
  // Space: O(N)
  // Time:  O(n/2)
  // public boolean isPalindrome(String s) {
  //     int len = null != s ? s.length() : 0;
  //     if (len < 0) {
  //         return false;
  //     }
  //     // Let string only have alphanumberic
  //     // Note: Regex used O(N) space
  //     String cleanedStr = s.replaceAll("[^a-zA-Z0-9]", "");
  //     len = null != cleanedStr ? cleanedStr.length() : 0;
  //     if (len < 0) {
  //         return false;
  //     }
  //     cleanedStr = cleanedStr.toLowerCase();
  //     int startIdx = 0, endIdx = len -1;
  //     while(startIdx < endIdx) {
  //         if (startIdx == endIdx) {
  //             return true;
  //         }
  //         if (cleanedStr.charAt(startIdx) != cleanedStr.charAt(endIdx)) {
  //             return false;
  //         }
  //         startIdx++;
  //         endIdx--;
  //     }
  //     return true;
  // }
}
