class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> l = new ArrayList<>();
        if (strings == null || strings.length == 0) { return l; }
        for (String str: strings) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < str.length(); i++) {
                sb.append(String.valueOf((str.charAt(i) - str.charAt(i - 1) + 26) % 26)).append(" ");
            }
            String s = sb.toString();
            if (!map.containsKey(s)) { map.put(s, new ArrayList<String>()); }
            map.get(s).add(str);
        }
        for (String key: map.keySet()) {
            l.add(map.get(key));
        }
        return l;
    }
}