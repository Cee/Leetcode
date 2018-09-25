class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>(Collections.reverseOrder());
        max = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        return min.size() == max.size() ? (max.peek() + min.peek()) / 2.0 : max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */