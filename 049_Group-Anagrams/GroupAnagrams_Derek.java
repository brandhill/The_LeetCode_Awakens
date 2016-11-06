/**
 * Author: Derek Lai
 * 
 * Questions:
 * 1. Is there any same alphabet in a string ?
 *    Ex: aab, ab => is belong to saem group ?
 * 2. If empty strs parameter is passed, what should return ? empty list ?
 * 
 */
public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
	if (strs == null || strs.length < 1) {
	  return null;
	}

	HashMap<String, List<String>> mapping = new HashMap<String, List<String>>();
	char[] sorted;
	String sortedStr;
	List<String> val;
	for (String s: strs) {
	  // if (null == s || s.length() == 0)
	  //     continue;
	  sorted = s.toCharArray();
	  Arrays.sort(sorted);
	  sortedStr = String.valueOf(sorted);
	  val = mapping.get(sortedStr);
	  if (null == val) {
		val = new ArrayList<String>();
	  }
	  val.add(s);
	  mapping.put(sortedStr, val);
	}
	return new ArrayList<List<String>>(mapping.values());
  }
}
