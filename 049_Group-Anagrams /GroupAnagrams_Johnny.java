/*
  Auther: Johnny Lee
  Question 1: Does the string only contain alphbet?
  Question 2: Does the array contain duplicate string?
  Question 3: Is the string array empty?
  Time complexicity: O(str.size() * strs.size()) // sort
  Space complexitty: O(strs.size()) // hashmap

  First thouht: Using sum as key but not working.
 */
 
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            String sortedStr = sortStr(strs[i]);
            List<String> list;
            if (map.containsKey(sortedStr)) {
                list = map.get(sortedStr);
            } else {
                list = new ArrayList();
                map.put(sortedStr, list);
            }
            list.add(strs[i]);
        }

        List<List<String>> result = new ArrayList();        
        for (String key: map.keySet()) {
            result.add(map.get(key));
        }
        
        return result;
    }
    
    private String sortStr(String str) {
        char[] charArray = str.toCharArray();
        boolean finished = false;
        for (int i = 0; i < charArray.length; i++) {
            finished = true; // reset
            for (int j = 0; j < charArray.length - i - 1; j++) {
                if (charArray[j] > charArray[j+1]) {
                    char tmp = charArray[j];
                    charArray[j] = charArray[j+1];
                    charArray[j+1] = tmp;
                    
                    finished = false;
                }
            }
        }
        
        return new String(charArray);
    }
}