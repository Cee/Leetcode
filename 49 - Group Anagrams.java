class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String rep = String.valueOf(arr);
            if (!map.containsKey(rep)) {
                map.put(rep, new ArrayList<>());
            }
            map.get(rep).add(str);
        }
        List<List<String>> l = new ArrayList<>();
        for (String key: map.keySet()) {
            l.add(map.get(key));
        }
        return l;
    }
}