class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> s = new HashSet<>();
        TreeSet<Integer> t = new TreeSet<>();
        for (int i: A) {
            TreeSet<Integer> r = new TreeSet<>();
            r.add(i);
            for (int j: t) {
                r.add(i | j);
            }
            t = r;
            for (int j: t) {
                s.add(j);
            }
        }
        
        return s.size();
    }
}