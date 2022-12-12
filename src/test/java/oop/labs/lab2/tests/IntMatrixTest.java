package oop.labs.lab2.tests;

import oop.labs.lab2.IntMatrixImmutable;
import oop.labs.lab2.IntMatrixMutable;
import org.junit.Test;

import static oop.labs.lab2.MatrixAssertions.assertThat;

public class IntMatrixTest
{
    @Test
    public void testEqualsHashCode()
    {
        var content1 = new int[][] {{1, 2}, {3, 4}};
        var content2 = new int[][] {{5, 6}, {7, 8}};

        var m1 = new IntMatrixMutable(content1);
        var m2 = new IntMatrixMutable(content2);

        var i1 = new IntMatrixImmutable(content1);
        var i2 = new IntMatrixImmutable(content2);

        assertThat(new IntMatrixMutable(content1))
                .isEqualTo(m1).hasSameHashCodeAs(m1)
                .isNotEqualTo(m2).doesNotHaveSameHashCodeAs(m2)
                .isEqualTo(i1).hasSameHashCodeAs(i1)
                .isNotEqualTo(i2).doesNotHaveSameHashCodeAs(i2);

        assertThat(new IntMatrixImmutable(content1))
                .isEqualTo(i1).hasSameHashCodeAs(i1)
                .isNotEqualTo(i2).doesNotHaveSameHashCodeAs(i2);
    }
}
