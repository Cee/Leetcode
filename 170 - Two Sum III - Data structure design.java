class TwoSum {

    Set<Integer> set;
    Set<Integer> dup;
    /** Initialize your data structure here. */
    public TwoSum() {
        set = new HashSet<>();
        dup = new HashSet<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (set.contains(number)) {
            dup.add(number);
        } else {
            set.add(number);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int num: set) {
            int sub = value - num;
            if (sub != num && set.contains(sub)) { return true; }
            if (sub == num && dup.contains(sub)) { return true; }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */