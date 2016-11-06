/**
 * Created by hill on 06/11/2016.
 * <p>
 * https://leetcode.com/problems/anagrams/
 * <p>
 * <p>
 * * Ask interviewer about following questions:
 * 1. Are these characters are all alpha ?
 * <p>
 * <p>
 * If the average length of verbs is m and array length is n
 * time: O(n*m)
 * Space: O(h)
 * <p>
 * <p>
 * Your runtime beats 70.40% of java submissions.
 */
public class GroupAnagrams {


    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<List<String>>();

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] charArr = new char[26];
            for (int i = 0; i < str.length(); i++) {
                charArr[str.indexOf(i) - 'a']++; // 把 char 跟 a 相減 相當於把 兩個 char 的 ascii 直拿來減，可以知道 是屬於哪一個 英文字母
            }

            String key = new String(charArr);

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        result.addAll(map.values());
        return result;
    }
}