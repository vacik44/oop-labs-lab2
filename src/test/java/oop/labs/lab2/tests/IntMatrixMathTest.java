package oop.labs.lab2.tests;

import oop.labs.lab2.IntMatrixImmutable;
import oop.labs.lab2.IntMatrixMutable;
import org.junit.Test;

import static oop.labs.lab2.tools.MatrixAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class IntMatrixMathTest
{
    @Test
    public void testMultiplication()
    {
        var contentOp1 = new int[][]
                {
                        {88, 76, 46},
                        {458, 459, 785}
                };

        var contentOp2 = new int[][]
                {
                        {57, 81, 96},
                        {44, 38, 45},
                        {72, 115, 25}
                };

        var contentResult = new Integer[][]
                {
                        {11672, 15306, 13018},
                        {102822, 144815, 84248},
                };

        assertThat(new IntMatrixMutable(contentOp1).dot(new IntMatrixMutable(contentOp2))).isSameMatrixAs(contentResult).isInstanceOf(IntMatrixMutable.class);
        assertThat(new IntMatrixMutable(contentOp1).dot(new IntMatrixImmutable(contentOp2))).isSameMatrixAs(contentResult).isInstanceOf(IntMatrixMutable.class);

        assertThat(new IntMatrixImmutable(contentOp1).dot(new IntMatrixImmutable(contentOp2))).isSameMatrixAs(contentResult).isInstanceOf(IntMatrixImmutable.class);
        assertThat(new IntMatrixImmutable(contentOp1).dot(new IntMatrixMutable(contentOp2))).isSameMatrixAs(contentResult).isInstanceOf(IntMatrixImmutable.class);

        assertThat(catchThrowable(() -> new IntMatrixImmutable(contentOp2).dot(new IntMatrixImmutable(contentOp1)))).isInstanceOf(IllegalArgumentException.class);
        assertThat(catchThrowable(() -> new IntMatrixImmutable(contentOp2).dot(new IntMatrixMutable(contentOp1)))).isInstanceOf(IllegalArgumentException.class);

        assertThat(catchThrowable(() -> new IntMatrixMutable(contentOp2).dot(new IntMatrixMutable(contentOp1)))).isInstanceOf(IllegalArgumentException.class);
        assertThat(catchThrowable(() -> new IntMatrixMutable(contentOp2).dot(new IntMatrixImmutable(contentOp1)))).isInstanceOf(IllegalArgumentException.class);
    }
}
