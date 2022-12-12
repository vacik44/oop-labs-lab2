package oop.labs.lab2.utils;

import oop.labs.lab2.Matrix;

public class TestUtils
{
    public static <TElement> void testOut(Matrix<TElement> matrix)
    {
        for (var i = 1; i <= matrix.rows(); i++)
        {
            for (var j = 1; j <= matrix.cols(); j++)
            {
                System.out.print(matrix.get(i, j).toString() + ", ");
            }

            System.out.println();
        }

        System.out.println();
    }


    public static void testOut(String string)
    {
        System.out.println(string);
        System.out.println();
    }

    public static void testOut(Object object)
    {
        System.out.println(object);
        System.out.println();
    }
}
