class Solution {
    func flipAndInvertImage(_ A: [[Int]]) -> [[Int]] {
        return A.map { (row: [Int]) in
            return row.reversed().map { (item: Int) in
                return item ^ 1
            }
        }
    }
}