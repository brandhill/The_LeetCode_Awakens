public class Solution {
  public boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    int toLower = 'a' - 'A';
    while (i < j) {
      char left = s.charAt(i);
      
      if ('A' <= left && left <= 'Z') {
        left += toLower;
      } else if (!(('a' <= left && left <= 'z') || ('0' <= left && left <= '9'))) {
          i++;
          continue;
      }
      char right = s.charAt(j--);
      if ('A' <= right && right <= 'Z') {
        right += toLower;
      } else if (!(('a' <= right && right <= 'z') || ('0' <= right && right <= '9'))) continue;
      if (left != right) return false;
      i++;    
    }
    return true;
  }
}
