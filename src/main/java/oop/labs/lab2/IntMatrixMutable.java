package oop.labs.lab2;

import java.util.List;

public class IntMatrixMutable extends IntMatrix
{
    public IntMatrixMutable()
    {
        super(buildMatrix());
    }


    protected IntMatrixMutable(boolean ignored, List<List<Integer>> elements)
    {
        super(elements);
    }


    public IntMatrixMutable(int rows, int cols, Integer init)
    {
        super(buildMatrix(rows, cols, init));
    }

    public IntMatrixMutable(int[][] matrix)
    {
        super(buildMatrix(matrix));
    }

    public <TRow extends Iterable<Integer>> IntMatrixMutable(Iterable<TRow> source)
    {
        super(buildMatrix(source));
    }

    public IntMatrixMutable(MatrixOfIntegers other)
    {
        super(buildMatrix(other));
    }


    public static IntMatrixMutable eye(int size)
    {
        return new IntMatrixMutable(false, buildIdentityMatrix(size));
    }


    @Override
    public Matrix<Integer> set(int row, int col, Integer value)
    {
        elements.get(row - 1).set(col - 1, value);
        return this;
    }


    @Override
    public Matrix<Integer> fillRow(int index, Iterable<Integer> source)
    {
        var row = elements.get(index - 1);

        var i = 0;
        for (var element: source)
        {
            row.set(i, element);
            i++;
        }

        return this;
    }

    @Override
    public Matrix<Integer> fillCol(int index, Iterable<Integer> source)
    {
        var i = 0;
        var c = index - 1;

        for (var element: source)
        {
            elements.get(i).set(c, element);
            i++;
        }

        return this;
    }


    @Override
    public Matrix<Integer> fillRow(int index, Integer[] source)
    {
        var row = elements.get(index - 1);

        var i = 0;
        for (var element: source)
        {
            row.set(i, element);
            i++;
        }

        return this;
    }

    @Override
    public Matrix<Integer> fillCol(int index, Integer[] source)
    {
        var i = 0;
        var c = index - 1;

        for (var element: source)
        {
            elements.get(i).set(c, element);
            i++;
        }

        return this;
    }


    @Override
    @SuppressWarnings("DuplicatedCode")
    public Matrix<Integer> fill(Integer[][] source)
    {
        var i = 0;

        for (var srcRow : source)
        {
            var row = elements.get(i);
            var j = 0;

            for (var element : srcRow)
            {
                row.set(j, element);
                j++;
            }

            i++;
        }

        return this;
    }

    @Override
    @SuppressWarnings("DuplicatedCode")
    public <TRow extends Iterable<Integer>> Matrix<Integer> fill(Iterable<TRow> source)
    {
        var i = 0;

        for (var srcRow : source)
        {
            var row = elements.get(i);
            var j = 0;

            for (var element : srcRow)
            {
                row.set(j, element);
                j++;
            }

            i++;
        }

        return this;
    }


    @Override
    public MatrixOfIntegers dot(MatrixOfIntegers other)
    {
        return new IntMatrixMutable(false, buildDotSource(other));
    }
}
