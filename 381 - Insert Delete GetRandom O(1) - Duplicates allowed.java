class RandomizedCollection {

    ArrayList<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random r;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        r = new Random(System.currentTimeMillis());
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean exist = true;
        if (!map.containsKey(val)) {
            map.put(val, new LinkedHashSet<>());
            exist = false;
        }
        list.add(val);
        map.get(val).add(list.size() - 1);
        return !exist;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val).iterator().next();
        map.get(val).remove(idx);
        if (idx < list.size() - 1) {
            int num = list.get(list.size() - 1);
            list.set(idx, num);
            map.get(num).remove(list.size() - 1);
            map.get(num).add(idx);
        }
        list.remove(list.size() - 1);
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */