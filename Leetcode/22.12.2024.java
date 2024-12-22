//Super Solid Question and Hard Question 
//Keerti Krishna Sreenivas S
//
class Solution {

    private int[] tree; // Segment tree array

    public int[] findLeftmostBuilding(int[] heights, int[][] queries) {
        int n = heights.length;
        tree = new int[4 * n + 1];
        int root = 1;

        buildTree(heights, 0, n - 1, root);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = Math.min(queries[i][0], queries[i][1]);
            int end = Math.max(queries[i][0], queries[i][1]);

            if (start == end || heights[end] > heights[start]) {
                result[i] = end;
                continue;
            }

            int low = end, high = n - 1, answer = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int maxIndex = queryTree(heights, low, mid, 0, n - 1, root);

                if (maxIndex != -1 && heights[maxIndex] > heights[start]) {
                    high = mid - 1;
                    answer = maxIndex;
                } else {
                    low = mid + 1;
                }
            }
            result[i] = answer;
        }
        return result;
    }

    private void buildTree(int[] heights, int left, int right, int index) {
        if (left == right) {
            tree[index] = left;
            return;
        }

        int mid = left + (right - left) / 2;
        buildTree(heights, left, mid, 2 * index);
        buildTree(heights, mid + 1, right, 2 * index + 1);

        tree[index] = heights[tree[2 * index]] >= heights[tree[2 * index + 1]]
                ? tree[2 * index] : tree[2 * index + 1];
    }

    private int queryTree(int[] heights, int queryStart, int queryEnd, int segmentStart, int segmentEnd, int index) {
        if (segmentStart > queryEnd || segmentEnd < queryStart) 
            return -1;

        if (segmentStart >= queryStart && segmentEnd <= queryEnd) 
            return tree[index];

        int mid = segmentStart + (segmentEnd - segmentStart) / 2;
        int leftMax = queryTree(heights, queryStart, queryEnd, segmentStart, mid, 2 * index);
        int rightMax = queryTree(heights, queryStart, queryEnd, mid + 1, segmentEnd, 2 * index + 1);

        if (leftMax == -1) return rightMax;
        if (rightMax == -1) return leftMax;

        return heights[leftMax] >= heights[rightMax] ? leftMax : rightMax;
    }
}
