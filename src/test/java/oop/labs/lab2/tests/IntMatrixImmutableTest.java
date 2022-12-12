package oop.labs.lab2.tests;

import oop.labs.lab2.IntMatrixImmutable;
import oop.labs.lab2.IntMatrixMutable;
import org.junit.Test;
import java.util.List;

import static oop.labs.lab2.assertions.MatrixAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class IntMatrixImmutableTest
{
    @Test
    public void testConstructors()
    {
        assertThat(new IntMatrixImmutable()).isEmpty();
        assertThat(new IntMatrixImmutable(2, 2, 1)).isSameMatrixAs(new Integer[][] {{1, 1}, {1, 1}});
        assertThat(new IntMatrixImmutable(new int[][] {{3, 45}, {123, 34}})).isSameMatrixAs(new Integer[][] {{3, 45}, {123, 34}});
        assertThat(new IntMatrixImmutable(List.of(List.of(12, 33, 56), List.of(22, 9, 0)))).isSameMatrixAs(new Integer[][] {{12, 33, 56}, {22, 9, 0}});
        assertThat(new IntMatrixImmutable(new IntMatrixImmutable(2, 3, 7))).isSameMatrixAs(new Integer[][] {{7, 7, 7}, {7, 7, 7}});
    }

    @Test
    public void testEyeMethod()
    {
        assertThat(IntMatrixImmutable.eye(5)).isSameMatrixAs(new Integer[][]
                {
                        {1, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1}
                });
    }

    @Test
    public void testAccessibility()
    {
        var matrix = new IntMatrixImmutable(new int[][] {
                {  12,  34,   6},
                {   3,  -7,  15},
                {-888,  19,   0}
        });

        assertThat(matrix.get(1, 1)).isEqualTo(12);
        assertThat(matrix.get(2, 2)).isEqualTo(-7);
        assertThat(matrix.get(3, 3)).isEqualTo(0);

        assertThat(matrix.row(1)).containsExactly(12, 34, 6);
        assertThat(matrix.row(2)).containsExactly( 3, -7, 15);
        assertThat(matrix.row(3)).containsExactly(-888, 19, 0);

        assertThat(matrix.col(1)).containsExactly(12, 3, -888);
        assertThat(matrix.col(2)).containsExactly( 34, -7, 19);
        assertThat(matrix.col(3)).containsExactly(6, 15, 0);
    }

    @Test
    public void testImmutability()
    {
        var matrix = new IntMatrixImmutable(1, 1, 1);

        assertThat(catchThrowable(() -> matrix.set(1, 1, 2))).isInstanceOf(UnsupportedOperationException.class);

        assertThat(catchThrowable(() -> matrix.fill(new Integer[][]{{1}}))).isInstanceOf(UnsupportedOperationException.class);
        assertThat(catchThrowable(() -> matrix.fill(List.of(List.of(1))))).isInstanceOf(UnsupportedOperationException.class);

        assertThat(catchThrowable(() -> matrix.fillRow(1, new Integer[] {2}))).isInstanceOf(UnsupportedOperationException.class);
        assertThat(catchThrowable(() -> matrix.fillCol(1, new Integer[] {2}))).isInstanceOf(UnsupportedOperationException.class);

        assertThat(catchThrowable(() -> matrix.fillRow(1, List.of(2)))).isInstanceOf(UnsupportedOperationException.class);
        assertThat(catchThrowable(() -> matrix.fillCol(1, List.of(2)))).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    public void testImmutableCast()
    {
        var mutable = new IntMatrixMutable(List.of(List.of(2, 3, 4)));
        var immutable = IntMatrixImmutable.immutable(mutable);

        assertThat(mutable).isSameMatrixAs(immutable).isEqualTo(immutable).hasSameHashCodeAs(immutable);
        assertThat(catchThrowable(() -> immutable.set(1, 2, 18))).isInstanceOf(UnsupportedOperationException.class);
    }
}
