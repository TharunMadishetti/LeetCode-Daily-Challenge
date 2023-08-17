class Solution {
    public int[][] updateMatrix(int[][] mat) {
       Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 0) {
					// only those added to queue who has 0 value.
					queue.add(new int[] { i, j });
				} else {
					// else set value to -1 to indicate length needed to be updated here.
					mat[i][j] = -1;
				}
			}
		}
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int length = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			// hold level count
			length++;
			// traverse level order wise
			while (size-- > 0) {
				int[] rc = queue.poll();
				// for each element in queue try all 4 directions
				for (int[] dir : dirs) {
					int r = rc[0] + dir[0];
					int c = rc[1] + dir[1];
					// if out of range or -1 it means no need to process it.
					if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] != -1) {
						continue;
					}
					// if not already -1. update length
					mat[r][c] = length;
					// add element to queue for processing
					queue.add(new int[] { r, c });
				}
			}
		}

		return mat;
	} 
    }