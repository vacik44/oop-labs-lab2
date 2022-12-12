package oop.labs.lab2.tools;

import oop.labs.lab2.Matrix;

public class MatrixAssertions
{
    public static <TElement> MatrixAssert<TElement> assertThat(Matrix<TElement> actual, Class<TElement> type)
    {
        return new MatrixAssert<>(actual, type);
    }

    public static MatrixAssert<Integer> assertThat(Matrix<Integer> actual)
    {
        return assertThat(actual, Integer.class);
    }
}
