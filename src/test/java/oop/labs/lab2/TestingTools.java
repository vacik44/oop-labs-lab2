package oop.labs.lab2;

import org.assertj.core.api.Object2DArrayAssert;

import java.lang.reflect.Array;

public class TestingTools
{
    @SuppressWarnings("unchecked")
    public static <TElement> Object2DArrayAssert<TElement> assertThat(Matrix<TElement> matrix, Class<TElement> type)
    {
        var array = (TElement[][]) Array.newInstance(type, matrix.rows(), matrix.cols());

        for (var i = 0; i < matrix.rows(); i++)
            for (var j = 0; j < matrix.cols(); j++)
                array[i][j] = matrix.get(i, j);

        return new Object2DArrayAssert<>(array);
    }

    public static Object2DArrayAssert<Integer> assertThat(Matrix<Integer> matrix)
    {
        return assertThat(matrix, Integer.class);
    }


    private static <TElement> void testOut(Matrix<TElement> matrix)
    {
        for (var i = 0; i < matrix.rows(); i++)
        {
            for (var j = 0; j < matrix.cols(); j++)
            {
                System.out.print(matrix.get(i, j).toString() + ", ");
            }

            System.out.println();
        }

        System.out.println();
    }


    private static void testOut(String string)
    {
        System.out.println(string);
        System.out.println();
    }

    private static void testOut(Object object)
    {
        System.out.println(object);
        System.out.println();
    }
}
