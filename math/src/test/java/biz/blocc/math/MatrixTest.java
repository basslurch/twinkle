package biz.blocc.math;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MatrixTest {

    @Test
    public void testCreate() {
        final Matrix matrix = new Matrix(2, 3);

        assertEquals(matrix.getNumRows(), 2);
        assertEquals(matrix.getNumColumns(), 3);
    }

    @Test
    public void testSetGet() {
        final Matrix matrix = new Matrix(4, 3);

        matrix.set(0, 0, 2.87);
        assertEquals(matrix.get(0, 0), 2.87, 1e-10);

        matrix.set(3, 1, 3.97);
        assertEquals(matrix.get(3, 1), 3.97, 1e-10);
    }

    @Test
    public void testCreateFromExternalArray() {
        double[][] array = new double[][]{{1, 2, 3}, {4, 5, 6}};

        final Matrix matrix = new Matrix(array);
        assertEquals(matrix.getNumRows(), 2);
        assertEquals(matrix.getNumColumns(), 3);

        assertEquals(matrix.get(0, 1), 2.0, 1e-10);
        assertEquals(matrix.get(1, 2), 6.0, 1e-10);
    }
}
