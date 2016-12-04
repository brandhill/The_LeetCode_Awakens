public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        ArrayList<String> result = new ArrayList();
        HashSet<String> isVisited = new HashSet();
        LinkedList<String> queue = new LinkedList();

        queue.add(s);
        isVisited.add(s);
        
        boolean found = false;
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (isValid(str)) {
                result.add(str);
                found = true;
            }
            
            if (found) {
                // just process the remaining same level items
                continue;
            }

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                    String substr = str.substring(0, i) + str.substring(i+1);
                    if (!isVisited.contains(substr)) {
                        queue.add(substr);
                        isVisited.add(substr);
                    }

                }
            }
        }
        
        return result;
    }
    
    private boolean isValid(String s) {
        int stack = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack++;
            } else if (s.charAt(i) == ')') {
                stack--;
                if (stack < 0) {
                    return false;
                }
            }
        }
        
        if (stack == 0) {
            return true;
        }
        
        return false;
    }
}