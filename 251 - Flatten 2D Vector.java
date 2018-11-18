public class Vector2D implements Iterator<Integer> {

    int row = 0, index = 0;
    List<List<Integer>> vec2d;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
    }

    @Override
    public Integer next() {
        Integer valToReturn = vec2d.get(row).get(index);
        if (index == vec2d.get(row).size() - 1) {
            row++;
            index = 0;
        } else {
            index++;
        }
        return valToReturn;
    }

    @Override
    public boolean hasNext() {
        if (vec2d.isEmpty() || row >= vec2d.size()) {
            return false;
        }
        if (index == vec2d.get(row).size()) {
            while (row != vec2d.size()) {
                if (vec2d.get(row).size() == 0) {
                    row++;
                } else {
                    break;
                }
            }
            if (row == vec2d.size()) {
                return false;
            }    
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */