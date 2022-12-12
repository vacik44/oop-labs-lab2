package oop.labs.lab2;

public class MatrixAssertions
{
    @SuppressWarnings("unchecked")
    public static <TElement> MatrixAssert<TElement> assertThat(Matrix<TElement> actual, Class<TElement> type)
    {
        return new MatrixAssert<TElement>(actual, type);
    }

    public static MatrixAssert<Integer> assertThat(Matrix<Integer> actual)
    {
        return assertThat(actual, Integer.class);
    }
}
