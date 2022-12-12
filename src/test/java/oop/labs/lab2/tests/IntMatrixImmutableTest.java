package oop.labs.lab2.tests;

import oop.labs.lab2.IntMatrixImmutable;
import org.junit.Test;
import java.util.List;

import static oop.labs.lab2.MatrixAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class IntMatrixImmutableTest
{
    @Test
    public void testConstructors()
    {
        assertThat(new IntMatrixImmutable()).isEmpty();
        assertThat(new IntMatrixImmutable(2, 2, 1)).isTheSameMatrixAs(new Integer[][] {{1, 1}, {1, 1}});
        assertThat(new IntMatrixImmutable(new int[][] {{3, 45}, {123, 34}})).isTheSameMatrixAs(new Integer[][] {{3, 45}, {123, 34}});
        assertThat(new IntMatrixImmutable(List.of(List.of(12, 33, 56), List.of(22, 9, 0)))).isTheSameMatrixAs(new Integer[][] {{12, 33, 56}, {22, 9, 0}});
        assertThat(new IntMatrixImmutable(new IntMatrixImmutable(2, 3, 7))).isTheSameMatrixAs(new Integer[][] {{7, 7, 7}, {7, 7, 7}});
    }

    @Test
    public void testEyeMethod()
    {
        assertThat(IntMatrixImmutable.eye(5)).isTheSameMatrixAs(new Integer[][]
                {
                        {1, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1}
                });
    }

    @Test
    public void testImmutability()
    {
        var matrix = new IntMatrixImmutable(1, 1, 1);

        assertThat(catchThrowable(() -> matrix.set(1, 1, 2))).isInstanceOf(UnsupportedOperationException.class);
        assertThat(catchThrowable(() -> matrix.fill(List.of(List.of(1))))).isInstanceOf(UnsupportedOperationException.class);
        assertThat(catchThrowable(() -> matrix.fillRow(1, new Integer[] {2}))).isInstanceOf(UnsupportedOperationException.class);
        assertThat(catchThrowable(() -> matrix.fillCol(1, new Integer[] {2}))).isInstanceOf(UnsupportedOperationException.class);
        assertThat(catchThrowable(() -> matrix.fillRow(1, List.of(2)))).isInstanceOf(UnsupportedOperationException.class);
        assertThat(catchThrowable(() -> matrix.fillCol(1, List.of(2)))).isInstanceOf(UnsupportedOperationException.class);
    }
}
