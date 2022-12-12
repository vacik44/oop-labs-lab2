package oop.labs.lab2;

import static oop.labs.lab2.utils.TestUtils.testOut;

public class TestingManual
{
    public static void main(String[] args)
    {
        var testMatrix = IntMatrixImmutable.eye(12);
        testOut(testMatrix);
    }
}
