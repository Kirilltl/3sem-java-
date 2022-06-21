package techprog.las.matrixes;
public class ElementSM {
    private int x = 0;
    private int y = 0;
    private int value = 0;
    public ElementSM(int x1, int y1, int val) {
        x = x1;
        y = y1;
        value = val;
    }
    int getVal() {
        return value;
    }
    int getX() {
        return x;
    }
    int getY() {
        return y;
    }
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        ElementSM m = (ElementSM) o;
        return (x == m.getX()) && (y == m.getY());
    }
}
