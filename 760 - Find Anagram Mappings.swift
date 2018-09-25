class Solution {
    func anagramMappings(_ A: [Int], _ B: [Int]) -> [Int] {
        var mapping = [Int: Int]()
        for (index, number) in B.enumerated() {
            mapping[number] = index
        }
        
        return A.map { mapping[$0]! }
    }
}