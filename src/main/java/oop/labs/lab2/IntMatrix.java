package oop.labs.lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class IntMatrix implements MatrixOfIntegers
{
    protected final List<List<Integer>> elements;


    protected IntMatrix(List<List<Integer>> elements)
    {
        this.elements = elements;
    }


    protected static List<List<Integer>> buildMatrix()
    {
        return new ArrayList<>(0);
    }

    protected static List<List<Integer>> buildMatrix(int rows, int cols, Integer init)
    {
        var matrix = new ArrayList<List<Integer>>(rows);

        for (var i = 0; i < rows; i++)
        {
            var row = new ArrayList<Integer>(cols);

            for (var j = 0; j < cols; j++)
                row.add(init);

            matrix.add(row);
        }

        return matrix;
    }

    protected static List<List<Integer>> buildMatrix(int[][] source)
    {
        var matrix = new ArrayList<List<Integer>>(source.length);

        for (var srcRow : source)
        {
            var row = new ArrayList<Integer>(srcRow.length);
            for (var element : srcRow) row.add(element);
            matrix.add(row);
        }

        return matrix;
    }

    protected static <TRow extends Iterable<Integer>> List<List<Integer>> buildMatrix(Iterable<TRow> source)
    {
        var matrix = new ArrayList<List<Integer>>();

        for (var srcRow : source)
        {
            var row = new ArrayList<Integer>();
            for (var element : srcRow) row.add(element);
            matrix.add(row);
        }

        return matrix;
    }

    protected static List<List<Integer>> buildMatrix(MatrixOfIntegers other)
    {
        var matrix = new ArrayList<List<Integer>>(other.rows());

        for (var i = 0; i < other.rows(); i++)
        {
            var content = new ArrayList<Integer>(other.cols());

            for (var element : other.row(i))
                content.add(element);

            matrix.add(content);
        }

        return matrix;
    }


    @Override
    public int[] size()
    {
        return new int[] {rows(), cols()};
    }

    @Override
    public int rows()
    {
        return elements.size();
    }

    @Override
    public int cols()
    {
        return rows() == 0 ? 0 : elements.get(0).size();
    }


    @Override
    public Integer get(int row, int col)
    {
        return elements.get(row).get(col);
    }


    @Override
    public Iterable<Integer> row(int index)
    {
        return Collections.unmodifiableList(elements.get(index));
    }

    @Override
    public Iterable<Integer> col(int index)
    {
        var column = new ArrayList<Integer>(rows());

        for (var row : elements)
            column.add(row.get(index));

        return Collections.unmodifiableList(column);
    }


    @Override
    public abstract MatrixOfIntegers dot(MatrixOfIntegers multiplier);
}