class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] visited = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();

        // Initialize the queue with water cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new Pair(i, j));
                    isWater[i][j] = 0;
                    visited[i][j] = 1;
                }
            }
        }

        // Perform BFS to calculate the highest peak
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                int[] dirX = {1, 0, -1, 0};
                int[] dirY = {0, 1, 0, -1};

                for (int j = 0; j < 4; j++) {
                    int newx = current.x + dirX[j];
                    int newy = current.y + dirY[j];

                    if (newx < 0 || newx >= m || newy < 0 || newy >= n || visited[newx][newy] == 1)
                        continue;

                    isWater[newx][newy] = isWater[current.x][current.y] + 1;
                    visited[newx][newy] = 1;
                    queue.add(new Pair(newx, newy));
                }
            }
        }

        return isWater;
    }
}
