class MyHashMap {

    int[] map;
    Set<Integer> set;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[1000001];
        set = new HashSet<>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
        set.add(key);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return set.contains(key) ? map[key] : -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (set.contains(key)) {
            set.remove(key);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */