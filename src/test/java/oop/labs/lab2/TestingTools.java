package oop.labs.lab2;

public class TestingTools
{
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
