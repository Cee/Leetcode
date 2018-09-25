class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < B.length; i++) {
            hashMap.put(B[i], i);
        }
        
        for (int i = 0; i < A.length; i++) {
            A[i] = hashMap.get(A[i]);            
        }
        
        return A;
    }
}