class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) { return list; }
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    row.add(1);
                } else {
                    row.add(list.get(list.size() - 1).get(j) + list.get(list.size() - 1).get(j - 1));
                }
            }
            list.add(row);
        }
        return list;
    }
}