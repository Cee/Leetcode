class RecentCounter {

    LinkedList<Integer> q;
    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        while (!q.isEmpty()) {
            if (q.peek() + 3000 < t) { 
                q.poll(); 
            } else {
                break;
            }
        }
        q.offer(t);
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */