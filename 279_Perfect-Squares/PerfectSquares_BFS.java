/**
 * Time(O(n*sqrt(n))
 *Spece(O(n))
 */
public class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> sqr = new ArrayList<>();
        for (int i = 1, square = i; square <= n; i++, square = i * i) {
            sqr.add(square);
        }
        int[] addedToVisited = new int[n+1];
        LinkedList<Integer> q = new LinkedList<>();
        q.add(n);
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            for (int i = 0, size = q.size(); i < size; i++) {
                int value = q.removeFirst();
                for (int squareValue:sqr) {
                    if (squareValue > value) {
                        break;
                    } else if (value == squareValue) {
                        return count;
                    }
                    int next = value - squareValue;
                    if (0 == addedToVisited[next]) {
                        q.add(next);
                        addedToVisited[next]++;
                    }
                }
            }
        }

        return count;
    }
}
