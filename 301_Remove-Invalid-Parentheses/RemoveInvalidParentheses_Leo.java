public class Solution {
  private void removeInvalidParentheses(List<String> ret, String s, int validIdx, int lastRemoved, char[] pair){
    int count = 0;
    for (int i = validIdx, size = s.length(); i < size;i++) {
      char c = s.charAt(i);
      if (c == pair[0]) {
        count++;
      } else if (c == pair[1]) {
        count--;
      }
      if (count >= 0) continue;
      char prev = lastRemoved > 0 ? s.charAt(lastRemoved-1) : '0';
      for (int j = lastRemoved; j <= i; j++) {
        char cc = s.charAt(j);
        if (cc == pair[1] && prev != cc) removeInvalidParentheses(ret, s.substring(0, j)+s.substring(j+1, size), i, j, pair); 
        prev = cc;
      }
      return;
    }
    
    if (0==count) {
      if ('(' == pair[1] ) s = new StringBuilder(s).reverse().toString();
      ret.add(s);
      return;
    } else {
      s = new StringBuilder(s).reverse().toString();
      removeInvalidParentheses(ret, s, 0, 0, new char[]{')', '('});
    }
  }
  
  public List<String> removeInvalidParentheses(String s) {
    List<String> ret = new ArrayList<>();
    removeInvalidParentheses(ret, s, 0, 0, new char[]{'(',')'});
    return ret;
  }
}
