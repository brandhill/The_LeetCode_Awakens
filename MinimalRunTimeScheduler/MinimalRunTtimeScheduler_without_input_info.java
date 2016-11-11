class Solution {
  private int getTasksCost(String tasks) {
    char prev = tasks.charAt(0); 
    int timeCost = 1;
    for (int i = 1, size = tasks.length(); i < size; i++) {
      char current = tasks.charAt(i); 
      if (current == prev) {
        timeCost += 3; 
      }
      prev = current; 
    }
    return timeCost;
  }


  public static class TaskSequence {
    String tasks;
    int timeCost;
    public String toString() {
      return "task:"+tasks+", time:"+timeCost;
    }
  }
  
  public TaskSequence calculateMinTasksCost(String tasks) {
      TaskSequence ret = new TaskSequence();
      if (null == tasks) return ret;
      int taskSize = tasks.length();
      if (taskSize == 0) return ret;
      int timeCost = 0;

      HashMap<Character, Integer> map = new HashMap<>();
      //caculate the number of each task type
      for (int i = 0; i < taskSize; i++) {
          char c = tasks.charAt(i); 
          Integer count = map.get(c);
          map.put(c, null != count ? count+1: 1);
      }

      StringBuilder sb = new StringBuilder();
      PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(map.size(), new Comparator<Map.Entry<Character, Integer>>(){
        public int compare (Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
          return e2.getValue() - e1.getValue();
        }
      });
      q.addAll(map.entrySet());

      Map.Entry<Character, Integer> prev = null;
      while (!q.isEmpty()) {
          Map.Entry<Character, Integer> entry = q.poll();
          sb.append(entry.getKey());
          timeCost++;
          Integer value = entry.getValue() - 1;
          if (null != prev) q.offer(prev);
          if (value > 0) {
            prev = entry;
            entry.setValue(value);
          } else {
            prev = null;
          }
      }
      if (null != prev) {
          char c = prev.getKey();
          for (int i = 0, size = prev.getValue(); i < size; i++) {
            sb.append(c);
            timeCost += 4;
          }
      }

      ret.tasks = sb.toString();
      ret.timeCost = timeCost;
      return ret;
  }

    
  
  public static void main(String[] args) {
      Solution s = new Solution();
      String input = "AAAAAAABB";
      log("ret:"+s.calculateMinTasksCost(input));
  }
}
