class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        
        int[] ans = new int[numCourses];
        while (!q.isEmpty()) {
            int course = q.poll();
            ans[count] = course;
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }
        return count == numCourses ? ans : new int[0];
    }
}