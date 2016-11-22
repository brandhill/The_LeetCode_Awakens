public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return getAllCombinations(s, wordDict, new HashMap<String, List<String>>());
    }
    
    private List<String> getAllCombinations(String s, Set<String> wordDict, HashMap<String, List<String>> record) {
        if (record.containsKey(s)) {
            return record.get(s);
        }
        
        LinkedList<String> list = new LinkedList();
        if (s.length() == 0) {
            list.add("");
        }
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> combinations = getAllCombinations(s.substring(word.length()), wordDict, record);
                for (int i = 0; i < combinations.size(); i++) {
                    list.add(word +(combinations.get(i).length() == 0 ? "" : " ")+combinations.get(i));
                }
            }
        }
        
        record.put(s, list);
        return list;
    }
}