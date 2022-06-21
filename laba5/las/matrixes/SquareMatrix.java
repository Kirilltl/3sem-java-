package techprog.las.matrixes;
public class SquareMatrix extends UsualMatrix implements IMatrix{
    public SquareMatrix(int s) {
        super(s,s);
        for (int i = 0; i < s; ++i) {
            this.setElem(i,i,1);
        }
    }

    public SquareMatrix sum(SquareMatrix m) {
        SquareMatrix result = new SquareMatrix(this.getRow());
        for (int i = 0; i < this.getRow(); ++i) {
            for (int j = 0; j < this.getRow(); ++j) {
                result.setElem(i, j, this.getElem(i,j) + m.getElem(i, j));
            }
        }
        return result;
    }
}
