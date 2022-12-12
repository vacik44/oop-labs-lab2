package oop.labs.lab2.tests;

import oop.labs.lab2.IntMatrixImmutable;
import org.junit.Test;
import java.util.List;

import static oop.labs.lab2.TestingTools.assertThat;

public class IntMatrixImmutableTest
{
    @Test
    public void testConstructors()
    {
        assertThat(new IntMatrixImmutable()).isEmpty();
        assertThat(new IntMatrixImmutable(2, 2, 1)).isDeepEqualTo(new Integer[][] {{1, 1}, {1, 1}});
        assertThat(new IntMatrixImmutable(new int[][] {{3, 45}, {123, 34}})).isDeepEqualTo(new Integer[][] {{3, 45}, {123, 34}});
        assertThat(new IntMatrixImmutable(List.of(List.of(12, 33, 56), List.of(22, 9, 0)))).isDeepEqualTo(new Integer[][] {{12, 33, 56}, {22, 9, 0}});
        assertThat(new IntMatrixImmutable(new IntMatrixImmutable(2, 3, 7))).isDeepEqualTo(new Integer[][] {{7, 7, 7}, {7, 7, 7}});
    }

    @Test
    public void testEyeMethod()
    {
        assertThat(IntMatrixImmutable.eye(5)).isDeepEqualTo(new Integer[][]
                {
                        {1, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1}
                });
    }
}
