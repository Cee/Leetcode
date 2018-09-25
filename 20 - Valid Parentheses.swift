class Solution {
    func isValid(_ s: String) -> Bool {
        let leftBrackets: [Character] = ["(", "[", "{"]
        var stack = [Character]()
        
        for c in s {
            if leftBrackets.contains(c) {
                stack.append(c)
            } else {
                guard let leftBracket = stack.last, pair(leftBracket, c) else {
                    return false
                }
                stack.removeLast()
            }
        }
        
        return stack.isEmpty
    }
    
    private func pair(_ lhs: Character, _ rhs: Character) -> Bool {
        return (lhs == "(" && rhs == ")")
            || (lhs == "[" && rhs == "]")
            || (lhs == "{" && rhs == "}")
    }
}

