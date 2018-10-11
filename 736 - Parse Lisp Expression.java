class Solution {
    int pos;
    LinkedList<Map<String, Integer>> scopes;
    public int evaluate(String expression) {
        pos = 0;
        scopes = new LinkedList<>();
        return eval(expression);
    }
    
    private int eval(String s) {
        System.out.println(s.substring(pos));
        scopes.addFirst(new HashMap<>());
        
        int value = 0;
        if (pos < s.length() && s.charAt(pos) == '(') { pos += 1; }
        
        String token = getToken(s);
        
        if (token.equals("add")) {
            // " exp1 exp2)"
            pos += 1;
            int v1 = eval(s);
            pos += 1;
            int v2 = eval(s);
            value = v1 + v2;
        } else if (token.equals("mult")) {
            // " exp1 exp2)"
            pos += 1;
            int v1 = eval(s);
            pos += 1;
            int v2 = eval(s);
            value = v1 * v2;
        } else if (token.equals("let")) {
            // " x1 v1 x2 v2 x3 v3 ... exp)"
            String var = new String();
            while (s.charAt(pos) != ')') {
                pos += 1;
                // exp
                if (s.charAt(pos) == '(') {
                    pos += 1;
                    value = eval(s);
                    break;
                }
                
                var = getToken(s);
                if (s.charAt(pos) == ')') {
                    if (Character.isLetter(var.charAt(0))) {
                        // x1 x2 x3
                        value = getValue(var);
                    } else {
                        // v1 v2 v3
                        value = Integer.valueOf(var);
                    }
                    break;
                }
                
                pos += 1;
                value = eval(s);
                scopes.getFirst().put(var, value);
            }
        } else if (Character.isLetter(token.charAt(0))) {
            value = getValue(token);
        } else {
            value = Integer.valueOf(token);
        }
        
        if (pos < s.length() && s.charAt(pos) == ')') { pos += 1; }
        scopes.removeFirst();
        return value;
    }
    
    private int getValue(String var) {
        for (int i = 0; i < scopes.size(); i++) {
            if (scopes.get(i).containsKey(var)) {
                return scopes.get(i).get(var);
            }
        }
        return 0;
    }
    
    private String getToken(String s) {
        StringBuilder sb = new StringBuilder();
        while (pos < s.length()) {
            if (s.charAt(pos) == ')' || s.charAt(pos) == ' ') {
                break;
            }
            sb.append(s.charAt(pos));
            pos += 1;
        }
        return sb.toString();
    }
}