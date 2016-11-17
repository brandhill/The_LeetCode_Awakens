public class Solution {
    public int intermediateValue1 = 0, intermediateValue2 = 0;
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 0) throw new IllegalArgumentException("cannot accept negative input.");

        List<Integer> numberSets = new LinkedList<Integer>();

        int result = 0;
        int target = x;

        while (target != 0) {
            numberSets.add(0, new Integer(target%100));
            target /= 100;
        }

        for (Integer i : numberSets) {
            target = findSqrtDigit(i);
            result = result * 10 + target;
        }

        return result;
    }

    private int findSqrtDigit(int element) {
        int target = 1;
        for (int i = 0; i <= 9; ++i) {
            if ((intermediateValue1 * 10 + i) * i <= intermediateValue2 * 100 + element) {
                target = i;
            } else {
                break;
            }
        }
        intermediateValue2 = (intermediateValue2 * 100 + element) - (intermediateValue1 * 10 + target) * target;
        intermediateValue1 = (intermediateValue1 * 10 + target) + target;
        return target;
    }
}

