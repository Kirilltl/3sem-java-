package techprog.las.matrixes;
public class UsualMatrix implements IMatrix{
    protected int [][] matrix;
    protected int r;
    protected int c;
    public UsualMatrix(int row, int column) {
        r = row; c = column;
        matrix = new int [row][column];
        for(int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                matrix[i][j] = 0;
    }

    public IMatrix sum(IMatrix l) {
        if((r != l.getRow()) || (c != l.getCol()))
            throw new MyException("sum, the sizes don't match");
        IMatrix res = new UsualMatrix(r, c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res.setElem(i, j, l.getElem(i, j) + this.getElem(i, j));
            }
        }
        return res;

    }

    public IMatrix multiplication(IMatrix l) {
        if(r != l.getCol() || c != l.getRow())
            throw new MyException("multiplication, the sizes don't match");
        IMatrix res = new UsualMatrix(r, l.getCol());
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l.getCol(); j++) {
                int mul = 0;
                for (int k = 0; k < c; k++) {
                    mul += this.getElem(i, k) * l.getElem(k, j);
                }
                res.setElem(i, j, mul);
            }
        }
        return res;
    }

    public int getRow() {
        return r;
    }

    public int getCol() {
        return c;
    }

    public void setElem(int row, int column, int value) {
        matrix[row][column] = value;
    }

    public int getElem(int row, int column) {
        return matrix[row][column];
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                res.append(" ").append(getElem(i,j));
            res.append("\n");
        }
        String s = res.toString();
        return s;
    }

    public boolean equals(Object o) {
        if(o == this)
            return true;
        if(o == null)
            return false;
        if(!( o instanceof IMatrix))
            return false;
        IMatrix l = (IMatrix) o;
        if (r != l.getRow() || c != l.getCol())
            return false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (this.getElem(i, j) != l.getElem(i, j))
                    return false;
            }
        }
        return true;
    }
}