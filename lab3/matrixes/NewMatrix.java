package techprog.lab3.matrixes;
public final class NewMatrix extends Matrix {	

	public 	NewMatrix(int r, int c) {
		super(r, 2);
		row = r;
		col = c;
	}
		
	public final int getElem(int row, int column) {
		return matrix[row][column % 2];
	}
	
	public final void setElem(int row, int column, int value) {
		matrix[row][column % 2] = value;
	}
}