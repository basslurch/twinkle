package biz.blocc.math;


public class Matrix {

    private final double[][] data;

    public Matrix(int rows, int columns) {
        data = new double[rows][columns];
    }

    public Matrix(double[][] array) {
        data = array;
    }

    public int getNumRows() {
        return data.length;
    }

    public int getNumColumns() {
        return data[0].length;
    }

    public void set(int row, int column, double value) {
        data[row][column] = value;
    }

    public double get(int row, int column) {
        return data[row][column];
    }
}
