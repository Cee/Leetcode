class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0) {
                indegree[ready]++;
            }
            matrix[pre][ready] = 1;
        }

        int count = 0;
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) { q.offer(i); }
        }
        while (!q.isEmpty()) {
            int course = q.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}