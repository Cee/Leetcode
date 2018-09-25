class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node() {}
        Node(int key, int val) { this.key = key; this.val = val; }
    }
    
    // Add after head
    private void add(Node n) {
        n.prev = head;
        n.next = head.next;
        
        head.next.prev = n;
        head.next = n;
    }
    
    // Remove
    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    private void head(Node n) {
        remove(n);
        add(n);
    }
    
    private Node pop() {
        Node ret = tail.prev;
        remove(ret);
        return ret;
    }
    
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int count;
    int capacity;
    
    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            head(n);
            return n.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.val = value;
            head(n);
        } else {
            Node n = new Node(key, value);
            map.put(key, n);
            add(n);
            count += 1;
            if (count > capacity) {
                Node tail = pop();
                map.remove(tail.key);
                count -= 1;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */