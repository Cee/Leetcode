// class Solution {
//     int cheapest;
//     boolean found;
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//         int[][] map = new int[n][n];
//         for (int[] flight: flights) {
//             int start = flight[0];
//             int end = flight[1];
//             int price = flight[2];
//             map[start][end] = price;
//         }
//         cheapest = Integer.MAX_VALUE;
//         found = false;
//         boolean[] visited = new boolean[n];
//         search(n, map, src, dst, 0, K, visited, 0);
//         return found ? cheapest : -1;
//     }
    
//     private void search(int n, int[][] map, int src, int dst, int i, int k, boolean[] visited, int price) {
//         if (visited[src]) { return; }
//         if (i > k) { return; }
//         if (src == dst) {
//             if (price < cheapest) {
//                 cheapest = price;
//                 found = true;
//             }
//             return;
//         }
//         visited[src] = true;
//         for (int j = 0; j < n; j++) {
//             if (map[src][j] != 0) {
//                 search(n, map, j, dst, j == dst ? i : i + 1, k, visited, price + map[src][j]);
//             }
//         }
//         visited[src] = false;
//     }
// }

class Solution {
     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for (int i = 0; i <= K; i++) {
            int[] temp = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {
                int cur = flight[0], next = flight[1], price = flight[2];
                if (prices[cur] == Integer.MAX_VALUE) continue;
                temp[next] = Math.min(temp[next], prices[cur] + price);
            }
            prices = temp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}