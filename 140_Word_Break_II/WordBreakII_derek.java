public class Solution {
  HashMap<String, List<String>> map = new HashMap<String, List<String>>();
  public List<String> wordBreak(String s, Set<String> wordDict) {
	List<String> res = new ArrayList<String>();
	if (null == s || s.length() == 0) {
	  return res;
	}
	if (map.containsKey(s)) {
	  return map.get(s);
	}
	if (wordDict.contains(s)) {
	  res.add(s);
	}
	String t;
	for (int i = 0; i<s.length() ; i++) {
	  t = s.substring(i);
	  if (wordDict.contains(t)) {
		List<String> temp = wordBreak(s.substring(0, i), wordDict);
		if (temp.size() != 0) {
		  for (String tt: temp) {
			res.add(tt+" "+t);
		  }
		}
	  }
	}
	map.put(s, res);
	return res;
  }
}
