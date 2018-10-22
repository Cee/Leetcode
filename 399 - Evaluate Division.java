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

class Solution {
     public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<Double>> valuesPair = new HashMap<String, ArrayList<Double>>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<String>());
                valuesPair.put(equation[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<String>());
                valuesPair.put(equation[1], new ArrayList<Double>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[0]).add(values[i]);
            valuesPair.get(equation[1]).add(1/values[i]);
        }
        
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
            if (result[i] == 0.0) result[i] = -1.0;
        }
        return result;
    }
    
    private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> values, HashSet<String> set, double value) {
        if (set.contains(start)) return 0.0;
        if (!pairs.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
        set.add(start);
        
        ArrayList<String> strList = pairs.get(start);
        ArrayList<Double> valueList = values.get(start);
        double tmp = 0.0;
        for (int i = 0; i < strList.size(); i++) {
            tmp = dfs(strList.get(i), end, pairs, values, set, value*valueList.get(i));
            if (tmp != 0.0) {
                break;
            }
        }
        set.remove(start);
        return tmp;
    }
}