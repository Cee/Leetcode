// Swap with last one
import java.util.Random;

class RandomizedSet {
    Random r;
    HashMap<Integer, Integer> indices; // num -> index
    ArrayList<Integer> list; // nums
    /** Initialize your data structure here. */
    public RandomizedSet() {
        r = new Random(System.currentTimeMillis());
        indices = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (indices.containsKey(val)) { return false; }
        indices.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!indices.containsKey(val)) { return false; }
        int loc = indices.get(val);
        if (loc < list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(loc, last);
            indices.put(last, loc);
        }
        indices.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */