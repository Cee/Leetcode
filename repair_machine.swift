import Foundation

func repair_machine(network: [[Int]], initial_machines: [Int]) -> [Int] {
    struct UnionFind {
        private var parent = [Int]()
        private var size = [Int]()
        private let initial: Set<Int>

        public init(count: Int, initial: [Int]) {
            for i in 0..<count {
                parent.append(i)
                size.append(1)
            }
            self.initial = Set(initial)
        }

        public mutating func find(_ element: Int) -> Int {
            if element == parent[element] {
                return element
            } else {
                parent[element] = parent[parent[element]]
                return parent[element]
            }
        }

        public mutating func union(_ lhs: Int, _ rhs: Int) {
            let parentOfLhs = find(lhs)
            let parentOfRhs = find(rhs)
            if (size[parentOfLhs] > size[parentOfRhs]) {
                parent[parentOfRhs] = parentOfLhs
                size[parentOfLhs] += size[parentOfRhs]
            } else {
                parent[parentOfLhs] = parentOfRhs
                size[parentOfRhs] += size[parentOfLhs]
            }
        }

        public func max() -> (index: Int, count: Int) {
            var result = (index: size.count, count: -1)
            for i in initial {
                var count = size[parent[i]]
                for j in initial {
                    if i != j && parent[i] == parent[j] {
                        count = 0
                        break
                    }
                }
                if count > result.count || count == result.count && i < result.index {
                    result = (i, count)
                }
            }
            return result
        }
    }

    // If # of columns != # of rows
    guard network.count == network.first?.count else {
        return [0, 0]
    }

    let n = network.count
    var unionFind = UnionFind(count: n, initial: initial_machines)
    for i in 0..<n - 1 {
        for j in i + 1..<n {
            if network[i][j] == 1 {
                unionFind.union(i, j)
            }
        }
    }

    let result = unionFind.max()
    return [result.0, result.1]
}

repair_machine(network: [[1, 1, 0, 0, 0],
                         [0, 1, 1, 0, 0],
                         [1, 0, 1, 1, 0],
                         [0, 1, 0, 1, 1],
                         [0, 0, 0, 1, 1]],
               initial_machines: [0, 4])
