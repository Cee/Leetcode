class HitCounter {

    int N;
    int[] count;
    int lastPosition;
    int lastTime;
    int sum;

    /** Initialize your data structure here. */
    public HitCounter() {
        N = 300;
        count = new int[N];
        lastPosition = 0;
        lastTime = 0;
        sum = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        move(timestamp);
        count[lastPosition]++;
        sum++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        move(timestamp);
        return sum;
    }
    
    void move(int timestamp){
        int gap = Math.min(timestamp - lastTime, N);
        for(int i = 0; i < gap; i++) {
            lastPosition = (lastPosition + 1) % N;
            sum -= count[lastPosition];
            count[lastPosition] = 0;
        }
        lastTime = timestamp;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */