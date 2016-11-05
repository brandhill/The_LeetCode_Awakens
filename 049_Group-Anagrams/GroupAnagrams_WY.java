public class Solution {

    private String sort(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        
        return new String(charArray);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null)
            return null;
        
        HashMap<String, List<String>> maps = new HashMap(strs.length);
        for(String s : strs) {
            String key = sort(s);
            List<String> list = maps.get(key);
            if(list == null) {
                list = new ArrayList<>();
                maps.put(key, list);
            }
            list.add(s);
        }
        
        List<List<String>> ret = new ArrayList<>();
        for(String key : maps.keySet()) {
            ret.add(maps.get(key));
        }
        
        return ret;
    }
}
