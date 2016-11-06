public class Solution {
    /*
    * Author: Leo Lu
    * Q1. What should do if we have two the same string??
    * Q2. What should we deal with empty string??
    * Q3. May we have a word with duplicate letter??
    * Time: O(Length of total strings+n) or O(n_avg+n) where n_avg is the average of input string, 
    * Space:O(n)
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        for (String s:strs) {
            char[] chars = new char[26];
            for (int i = 0, size = s.length(); i < size; i++) {
                chars[s.charAt(i)-'a']++;
            }
            String key = new String(chars);
            LinkedList<String> list = map.get(key);
            if (null == list) {
                list = new LinkedList<>();
                map.put(key, list);
            }
            list.add(s);
        }

        return new ArrayList<>(map.values());
    }
}
