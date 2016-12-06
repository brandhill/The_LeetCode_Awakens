public class Solution {
    HashMap<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (wordDict.contains(s)) {
            result.add(s);
        }
        if(map.containsKey(s)) {
            return map.get(s);
        }
        
        for(int i=1; i<s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if(wordDict.contains(left) && containsPrefix(right, wordDict)) {
                for(String ss : wordBreak(right, wordDict)) {
                    result.add(left + " " + ss);
                }
            }
        }
        map.put(s, result);
        return result;
        
    }
    
    private boolean containsPrefix(String sub, Set<String> wordDict) {
        for(String word2 : wordDict) {
            if(sub.startsWith(word2))
                return true;
        }
        return false;
    }
}
