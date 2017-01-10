package jtest;

public class Matrix {
	private double numbers[][];
	private int width;
	private int height;
	
	public Matrix(int width, int height) {
		if (width < 1) {
			throw new IllegalArgumentException("Width cannot be less than 1");
		}
		if (height < 1) {
			throw new IllegalArgumentException("Height cannot be less than 1");
		}
		this.width = width;
		this.height = height;
		numbers = new double[width][height];
		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				numbers[i][j] = 0;
			}
		}
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setNumber(int width, int height, double value) {
		if (width < 1) {
			throw new IllegalArgumentException("Width cannot be less than 1");
		}
		if (height < 1) {
			throw new IllegalArgumentException("Height cannot be less than 1");
		}
		numbers[width-1][height-1] = value;
	}
	
	public double getNumber(int width, int height) {
		if (width < 1) {
			throw new IllegalArgumentException("Width cannot be less than 1");
		}
		if (height < 1) {
			throw new IllegalArgumentException("Height cannot be less than 1");
		}
		return numbers[width-1][height-1];
	}
	
	public void scalarMultiply(double scalar) {
		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				numbers[i-1][j-1] *= scalar;
			}
		}
	}
	
	public void add(Matrix other) {
		if (this.height != other.getHeight()) {
			throw new IllegalArgumentException("Height of both matrices must be the same");
		}
		if (this.width != other.getWidth()) {
			throw new IllegalArgumentException("Width of both matrices must be the same");
		}
		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				numbers[i-1][j-1] += other.getNumber(i, j);
			}
		}
	}
	
	public Matrix multiply(Matrix other) {
		if (this.width != other.getHeight()) {
throw new IllegalArgumentException("Width of this matrix should be equal to height of other matrix");
		}
		Matrix result = new Matrix(this.height, other.getWidth());
		for (int i=1; i<=width; i++) {
			BoundVector resultColumn = new BoundVector(numbers[i]);
			BoundVector resultRow = new BoundVector(height);
			for (int j=1; j<=height; j++) {
				resultRow.setCoordinate(j-1, other.getNumber(i, j));
			}
			result.setNumber(i, i, resultRow.inproduct(resultColumn));
		}
		return result;
	}
	
	
 
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i=1; i<=width; i++) {
			for (int j=1; j<=height; j++) {
				result.append(this.getNumber(i, j));
				result.append(" ");
			}
			result.append("\n");
		}
		return new String(result);
	}
	
	@Override
	public int hashCode() {
		// primitive implementation, does not work for larger matrices
		int result = 1;
		for (int i=1; i<=width; i++) {
			for (int j=1; j<=height; j++) {
				result = (int) (result * this.getNumber(i, j)) * i;
			}
		}
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Matrix)) {
			return false;
		}
		Matrix otherMatrix = (Matrix)other;
		// Matrices are equal if all cells are equal
		for (int i=1; i<=width; i++) {
			for (int j=1; j<=height; j++) {
				if (this.getNumber(i, i) != otherMatrix.getNumber(i, i)) {
					return false;
				}
			}
		}
		return true;
	}

	private static Matrix fillMatrix(int length, int width) {
		Matrix result = new Matrix(length, width);
		int value = 1;
		for (int i=1; i<=length; i++) {
			for (int j=1; j<=width; j++) {
				result.setNumber(i, j, value++);
			}
		}
		return result;
	}
	
}
