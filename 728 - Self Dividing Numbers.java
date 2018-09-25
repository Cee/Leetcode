class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (check(i)) {
                list.add(i);
            }
        }
        return list;
    }
    
    private boolean check(int n) {
        int temp = n;
        while (temp > 0) {
            int divisor = temp % 10;
            if (divisor == 0) {
                return false;
            }
            if (n % divisor != 0) {
                return false;
            }
            temp = temp / 10;
        }
        return true;
    }
}