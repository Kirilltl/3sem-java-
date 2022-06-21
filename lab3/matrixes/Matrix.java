package techprog.lab3.matrixes;
public class Matrix {
	protected final int[][] matrix;
	protected int row;
	protected int col;
	public Matrix(int s, int b) {
		row = s;
		col = b;
		matrix = new int[row][col];
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) 
				matrix[i][j] = 0;		
		}
	}

	public Matrix add(Matrix m) {
		if(row != m.getRow() || col != m.getCol())
			throw new MyException("add, the sizes don't match");
		Matrix result = new Matrix(row,col);
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				result.setElem(i, j, this.getElem(i,j) + m.getElem(i, j));
			}
		}
		return result;
	}

	public Matrix mult(Matrix m) {
		if(row != m.getCol() || col != m.getRow())
			throw new MyException("mult, the sizes don't match");
		Matrix result = new Matrix(row,col);
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				int mult = 0;
				for (int k = 0; k < row; ++k) {
					mult += this.getElem(i, k) * m.getElem(k, j);
				}
				result.setElem(i, j, mult);
			}
		}
		return result;
	}

	public void setElem(int row, int column, int value) {
		matrix[row][column] = value;
	}

	public int getElem(int row, int column) {
		return matrix[row][column];
	}

	public final int getRow() {
		return row;
	}
	public final int getCol() {
		return col;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				str.append(getElem(i,j));
				str.append(' ');
			}
			str.append('\n');
		}	
		String s = str.toString();
		return s;
	}
	
	public boolean equals(Matrix m){
		if ((row != m.getRow()) || (col != m.getCol()))
			return false;
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if(matrix[i][j] != m.getElem(i,j))
					return false;
			}
		}
		return true;					
	}	
}