class ValidWordAbbr {

    Map<String, Set<String>> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String s: dictionary) {
            String r = presentation(s);
            if (!map.containsKey(r)) {
                map.put(r, new HashSet<String>());
            }
            map.get(r).add(s);
        }
    }
    
    public boolean isUnique(String word) {
        String r = presentation(word);
        return !map.containsKey(r) || (map.get(r).contains(word) && map.get(r).size() == 1);
    }
    
    private String presentation(String s) {
        int length = s.length();
        if (length <= 2) {
            return s;
        } else {
            return s.charAt(0) + String.valueOf(length - 2) + s.charAt(length - 1);
        }
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */