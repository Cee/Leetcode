class Solution {
    
    class Node {
        String parent;
        double ratio;
        public Node(String p, double r) {
            parent = p;
            ratio = r;
        }
    }
    
    Map<String, Node> map;
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String s1 = equations[i][0];
            String s2 = equations[i][1];
            Node n1 = find(s1);
            Node n2 = find(s2);
            if (!n1.parent.equals(n2.parent)) {
                map.put(n1.parent, new Node(n2.parent, 
                                            values[i] * n2.ratio / n1.ratio));
            }
        }
        
        double[] ans = new double[queries.length];
        Arrays.fill(ans, -1.0);
        for (int i = 0; i < queries.length; i++) {
            String s1 = queries[i][0];
            String s2 = queries[i][1];
            if (!map.containsKey(s1) || !map.containsKey(s2)) {
                continue;
            }
            Node n1 = find(s1);
            Node n2 = find(s2);
            if (!n1.parent.equals(n2.parent)) { continue; }
            ans[i] = n1.ratio / n2.ratio;
        }
        
        return ans;
    }
    
    private Node find(String s) {
        if (!map.containsKey(s)) {
            Node n = new Node(s, 1.0);
            map.put(s, n);
            return n;
        }
        Node n = map.get(s);
        double r = 1.0;
        while (!s.equals(map.get(s).parent)) {
            r *= map.get(s).ratio;
            s = map.get(s).parent;
        }
        n.parent = s;
        n.ratio = r;
        return n;
    }
}