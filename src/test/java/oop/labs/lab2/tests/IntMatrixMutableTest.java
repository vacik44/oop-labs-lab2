package oop.labs.lab2.tests;

import oop.labs.lab2.IntMatrixImmutable;
import oop.labs.lab2.IntMatrixMutable;
import org.junit.Test;
import java.util.List;

import static oop.labs.lab2.assertions.MatrixAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class IntMatrixMutableTest
{
    @Test
    public void testConstructors()
    {
        assertThat(new IntMatrixMutable()).isEmpty();
        assertThat(new IntMatrixMutable(2, 2, 1)).isSameMatrixAs(new Integer[][] {{1, 1}, {1, 1}});
        assertThat(new IntMatrixMutable(new int[][] {{3, 45}, {123, 34}})).isSameMatrixAs(new Integer[][] {{3, 45}, {123, 34}});
        assertThat(new IntMatrixMutable(List.of(List.of(12, 33, 56), List.of(22, 9, 0)))).isSameMatrixAs(new Integer[][] {{12, 33, 56}, {22, 9, 0}});
        assertThat(new IntMatrixMutable(new IntMatrixImmutable(2, 3, 7))).isSameMatrixAs(new Integer[][] {{7, 7, 7}, {7, 7, 7}});
    }

    @Test
    public void testEyeMethod()
    {
        assertThat(IntMatrixMutable.eye(5)).isSameMatrixAs(new Integer[][]
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
        var matrix = new IntMatrixMutable(new int[][] {
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
    public void testMutability()
    {
        var matrix = new IntMatrixMutable(3, 3, null);

        assertThat(matrix.fill(new Integer[][]{{1, 2, 3}, {3, 4, 5}, {6, 7, 8}})).isSameMatrixAs(new Integer[][]{{1, 2, 3}, {3, 4, 5}, {6, 7, 8}});

        assertThat(matrix.set(1, 1, null)).isSameMatrixAs(new Integer[][]{{null, 2, 3}, {3, 4, 5}, {6, 7, 8}});
        assertThat(matrix.set(2, 2, null)).isSameMatrixAs(new Integer[][]{{null, 2, 3}, {3, null, 5}, {6, 7, 8}});
        assertThat(matrix.set(3, 3, null)).isSameMatrixAs(new Integer[][]{{null, 2, 3}, {3, null, 5}, {6, 7, null}});

        assertThat(matrix.fillRow(1, List.of(0, -1, -10))).isSameMatrixAs(new Integer[][]{{0, -1, -10}, {3, null, 5}, {6, 7, null}});
        assertThat(matrix.fillRow(3, new Integer[] {12, 16, 1})).isSameMatrixAs(new Integer[][]{{0, -1, -10}, {3, null, 5}, {12, 16, 1}});

        assertThat(matrix.fillCol(1, List.of(12, -12, 0))).isSameMatrixAs(new Integer[][]{{12, -1, -10}, {-12, null, 5}, {0, 16, 1}});
        assertThat(matrix.fillCol(3, new Integer[] {122, -1, -23})).isSameMatrixAs(new Integer[][]{{12, -1, 122}, {-12, null, -1}, {0, 16, -23}});

        assertThat(matrix.fill(List.of(List.of(11, -12, 13), List.of(-14, 15, -16), List.of(17, -18, 19)))).isSameMatrixAs(new Integer[][]{{11, -12, 13}, {-14, 15, -16}, {17, -18, 19}});
    }
}
