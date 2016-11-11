class Solution {
    public static void log(List<List<Integer>> lists) {
        for (List<Integer> list:lists) {
            StringBuilder sb = new StringBuilder();
            for (Object o:list) {
                if (sb.length() > 0) sb.append(',');
                sb.append(o.toString());
            }
            log(sb.toString());
        }
    }
    
    public static void log(String s) {
        System.out.println(s);
    }
  
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
  
  private static final int TYPES = 26;
  public TaskSequence calculateMinTasksCost(String tasks) {
    TaskSequence ret = new TaskSequence();
    if (null == tasks) return ret;
    int taskSize = tasks.length();
    if (taskSize == 0) return ret;
    int timeCost = 0;

    int[] numOfTask = new int[TYPES];

    //caculate the number of each task type
    for (int i = 0; i < taskSize; i++) {
        numOfTask[tasks.charAt(i)-'A']++;
    }

    StringBuilder sb = new StringBuilder();

    //pick the task to reaarange a new one
    int prevIndex = -2;

    for (int i = 0 ;i < taskSize; i++) {
        int index = -1;
        int max = 0;
        // .......A 
        // A B C 
        // 2 0 0
        for (int j = 0, size = TYPES; j < size; j++) {
          if (max < numOfTask[j] && j != prevIndex) {
            index = j;
            max = numOfTask[j];
          }
        }

        if (index < 0) {
          char c = (char)(prevIndex+'A');
          for (int k = i; k < taskSize; k++) {
            timeCost += 4;
            sb.append(c);
          }
          break;
        }

        prevIndex = index;
        numOfTask[index]--;
        char c = (char)(index+'A');
        timeCost++;
        sb.append(c);
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
