class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        for (String deadend: deadends) { visited.add(deadend); }
        LinkedList<String> queue = new LinkedList<>();
        if (visited.contains("0000")) { return -1; }
        queue.offer("0000");
        visited.add("0000");
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                char[] arr = s.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char c = arr[j];
                    for (int k = -1; k <= 1; k += 2) {
                        arr[j] = (char)('0' + (c - '0' + k + 10) % 10);
                        String str = String.valueOf(arr);
                        if (str.equals(target)) { return count + 1; }
                        if (!visited.contains(str)) {
                            queue.offer(str);
                            visited.add(str);
                        }
                    }
                    arr[j] = c;
                }
            }
            count += 1;
        }
        return -1;
    }
}