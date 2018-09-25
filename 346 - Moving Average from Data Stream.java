class MovingAverage {

    private int[] array;
    private int index = 0;
    private int sum = 0;
    private int size;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        array = new int[size];
        this.size = size;
    }
    
    public double next(int val) {
        double avg;
        sum += val;
        if (index >= size) {
            sum -= array[index % size];
            array[index % size] = val;
            avg = (double)sum / size;
        } else {
            array[index] = val;
            avg = (double)sum / (index + 1);
        }
        index += 1;
        return avg;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */