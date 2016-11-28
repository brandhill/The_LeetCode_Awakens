/*
	Author: Charles Tsai
	
	Provide a simple recursive solution. Unfortunately it cannot pass the verification. Time limit exceeded.
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean result = false;
        
        if (s.isEmpty()) return true;
        
        for (String keyword : wordDict) {
            
            if (s.equals(keyword)) {
                //System.out.println("it's " + keyword + ". match!");
                return true;
            }
            
            if (s.contains(keyword)) {
                String prefixStr = s.substring(0, s.indexOf(keyword));
                String suffixStr = s.substring(s.indexOf(keyword) + keyword.length(), s.length());
                //System.out.println("match for " + keyword + ". checking for " + prefixStr + " and " + suffixStr);
                
                result |= (wordBreak(prefixStr, wordDict) && wordBreak(suffixStr, wordDict));
            }
        }
        
        //System.out.println("return " + result + " for " + s);
        return result;
    }
}

/*
    DP solution to make task complete faster.

*/
public class Solution {

    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len+1];
        f[0] = true;
        for (int i=1; i<len+1; i++)
            for (int j=0; j<i; j++)
                if (f[j] && wordDict.contains(s.substring(j,i)))
                {
                    f[i] = true;
                    break;
                }
        return f[len];
    }
}
