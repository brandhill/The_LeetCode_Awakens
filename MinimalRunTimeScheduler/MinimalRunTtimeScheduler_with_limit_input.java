class Solution {
  private static final int TYPES = 26;
  public int calculateMinTasksCost(String tasks) {
    int taskSize = tasks.length();
    if (null == tasks || taskSize == 0) return 0;
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
  
    return timeCost;
  }
}
