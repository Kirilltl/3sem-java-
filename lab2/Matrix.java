public class Matrix {
	private int[][] matrix;
	private int size;
	public Matrix(int s) {
		size = s;
		matrix = new int[size][size];
		for (int i = 0; i < size; ++i) {
			matrix[i][i] = 1;		
		}
	}

	public Matrix add(Matrix m) {
		Matrix result = new Matrix(size);
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				result.setElem(i, j, matrix[i][j] + m.getElem(i, j));
			}
		}
		return result;
	}
	
	

	public Matrix mult(Matrix m) {
		Matrix result = new Matrix(size);
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				int mult = 0;
				for (int k = 0; k < size; ++k) {
					mult += matrix[i][k] * m.getElem(k, j);
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

	public int getSize() {
		return size;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				str.append(matrix[i][j]);
				str.append(' ');
			}
			str.append('\n');
		}	
		String s = str.toString();
		return s;
	}
		
	private int sumRow(int idx){
		int sum = 0;
		for(int i = 0; i < size; i++)
			sum += matrix[idx][i];
		return sum;	
	}
	
	public void sumSort() {
		int[] arrSum = new int[size];
		for(int i = 0; i < size; i++)
			arrSum[i] = sumRow(i);	
		int[] arrIdx = new int[size];
		for(int i = 0; i < size; i++)
			arrIdx[i] = i;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size-1; j++){
				if(arrSum[j] < arrSum[j+1]){
					int tmp = arrSum[j];
					arrSum[j] = arrSum[j+1];
					arrSum[j+1] = tmp;			
					tmp = arrIdx[j];
					arrIdx[j] = arrIdx[j+1];
					arrIdx[j+1] = tmp;				
				}					
			}
		}	
		for(int i = 0; i < size; i++){	
			for(int j = 0; j < size; j++){
				System.out.print(matrix[arrIdx[i]][j] + " ");
			}
			System.out.print("\n");
		}                      
	}
				
	public static void main(String[] args) {
			Matrix m = new Matrix(5);
			m.setElem(1, 0, 1);
			m.setElem(2, 2, -3);
			m.setElem(4, 2, -9);
			System.out.println(m);
			m.sumSort();
			
			/*Matrix result = m;
			for (int i = 0; i < 10; ++i) {
				System.out.println("Steps of Pow: ");
				System.out.println(result);
				result = result.mult(m);			
			}*/		
	}
}