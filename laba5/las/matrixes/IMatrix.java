package techprog.las.matrixes;
    public interface IMatrix {
        IMatrix sum(IMatrix l);
        IMatrix multiplication(IMatrix l);
        void setElem(int row, int column, int value);
        int getElem(int row, int column);
        int getRow();
        int getCol();
    }
