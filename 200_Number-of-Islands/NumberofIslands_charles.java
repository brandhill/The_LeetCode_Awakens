public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        boolean[][] discoveredNodes = new boolean[grid.length][grid[0].length];
        int result = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (discoveredNodes[i][j]) {
                    continue;
                }
                if (bfs(grid, discoveredNodes, i, j)) {
                    ++result;
                }
            }
        }

        return result;
    }

    private boolean bfs(char[][] grid, boolean[][] discoveredNodes, int x, int y) {
        boolean result = false;

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return false;
        }

        Queue<ArrayList<Integer>> queue = new ArrayDeque<ArrayList<Integer>>();

        if (grid[x][y] == '0') {
            discoveredNodes[x][y] = true;
            return false;
        } else {
            enqueue(queue, x, y);

            while (!queue.isEmpty()) {
                List<Integer> node = queue.poll();

                int localX = node.get(0).intValue();
                int localY = node.get(1).intValue();

                if ((localX >= 0) && (localY >= 0) && (localX < grid.length) && (localY < grid[0].length)) {
                    if ((grid[localX][localY] == '0')) {
                        continue;
                    }

                    if (!discoveredNodes[localX][localY]) {
                        discoveredNodes[localX][localY] = true;
                        enqueue(queue, localX, localY + 1);
                        enqueue(queue, localX + 1, localY);
                        enqueue(queue, localX, localY - 1);
                        enqueue(queue, localX - 1, localY);
                    }
                }
            }

            return true;
        }
    }

    private void enqueue(Queue<ArrayList<Integer>> queue, int x, int y) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);
        queue.add(list);
    }
}
