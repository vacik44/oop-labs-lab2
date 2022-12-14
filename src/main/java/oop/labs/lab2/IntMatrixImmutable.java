package oop.labs.lab2;

import java.util.Collections;
import java.util.List;

public final class IntMatrixImmutable extends IntMatrix
{
    private static List<List<Integer>> makeImmutable(List<List<Integer>> matrix)
    {
        matrix.replaceAll(Collections::unmodifiableList);
        return Collections.unmodifiableList(matrix);
    }


    private IntMatrixImmutable(boolean ignored, List<List<Integer>> elements)
    {
        super(makeImmutable(elements));
    }


    public IntMatrixImmutable()
    {
        super(makeImmutable(buildMatrix()));
    }

    public IntMatrixImmutable(int rows, int cols, Integer init)
    {
        super(makeImmutable(buildMatrix(rows, cols, init)));
    }

    public IntMatrixImmutable(int[][] matrix)
    {
        super(makeImmutable(buildMatrix(matrix)));
    }

    public <TRow extends Iterable<Integer>> IntMatrixImmutable(Iterable<TRow> source)
    {
        super(makeImmutable(buildMatrix(source)));
    }

    public IntMatrixImmutable(MatrixOfIntegers other)
    {
        super(makeImmutable(buildMatrix(other)));
    }


    public static IntMatrixImmutable eye(int size)
    {
        return new IntMatrixImmutable(false, buildIdentityMatrix(size));
    }

    public static IntMatrixImmutable immutable(IntMatrixMutable matrix)
    {
        return new IntMatrixImmutable(false, matrix.elements);
    }


    @Override
    public MatrixOfIntegers dot(MatrixOfIntegers other)
    {
        return new IntMatrixImmutable(false, buildDotSource(other));
    }


    @Override public Matrix<Integer> set(int row, int col, Integer value) { throw new UnsupportedOperationException(); }

    @Override public Matrix<Integer> fillRow(int index, Iterable<Integer> source) { throw new UnsupportedOperationException(); }
    @Override public Matrix<Integer> fillCol(int index, Iterable<Integer> source) { throw new UnsupportedOperationException(); }

    @Override public Matrix<Integer> fillRow(int index, Integer[] source) { throw new UnsupportedOperationException(); }
    @Override public Matrix<Integer> fillCol(int index, Integer[] source) { throw new UnsupportedOperationException(); }

    @Override public Matrix<Integer> fill(Integer[][] source) { throw new UnsupportedOperationException(); }
    @Override public <TRow extends Iterable<Integer>> Matrix<Integer> fill(Iterable<TRow> source) { throw new UnsupportedOperationException(); }
}
