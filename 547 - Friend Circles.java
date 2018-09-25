// class Solution {
//     public int findCircleNum(int[][] M) {
//         int count = 0;
//         boolean[] visited = new boolean[M.length];
//         LinkedList<Integer> queue = new LinkedList<>();
//         for (int i = 0; i < M.length; i++) {
//             if (visited[i]) { continue; }
//             queue.offer(i);
//             while (!queue.isEmpty()) {
//                 int friend = queue.poll();
//                 visited[friend] = true;
//                 for (int j = 0; j < M.length; j++) {
//                     if (M[friend][j] == 1 && !visited[j]) {
//                         queue.offer(j);
//                     }
//                 }
//             }
//             count += 1;
//         }
//         return count;
//     }
    
// }
class Solution {
    int n;
   	public int findCircleNum(int[][] M) {
		n = M.length;
		int circle = 0;
		boolean[] visited = new boolean[n];
		for (int i= 0; i < n; i++) {
			if (!visited[i]) {
				dfs(M, visited, i);
				circle++;
			}
		}
		return circle;
	}
	
	public void dfs(int[][] M, boolean[] visited, int i) {
		visited[i] = true;
		for(int j = 0; j < n; j++) {
			if (!visited[j] && M[i][j] == 1) {
				dfs(M, visited, j);
			}
		}
	}
}