package oop.labs.lab2;

import org.assertj.core.api.ObjectAssert;

import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixAssert<TElement> extends ObjectAssert<Matrix<TElement>>
{
    TElement[][] actualContent;
    Class<TElement> actualContentType;


    @SuppressWarnings("unchecked")
    private static <T> T[][] extractContent(Matrix<T> matrix, Class<T> type)
    {
        var content = (T[][]) Array.newInstance(type, matrix.rows(), matrix.cols());

        for (var i = 0; i < matrix.rows(); i++)
            for (var j = 0; j < matrix.cols(); j++)
                content[i][j] = matrix.get(i, j);

        return content;
    }


    public MatrixAssert(Matrix<TElement> actual, Class<TElement> type)
    {
        super(actual);

        actualContent = extractContent(actual, type);
        actualContentType = type;
    }

    public MatrixAssert(AtomicReference<Matrix<TElement>> actual, Class<TElement> type)
    {
        super(actual);

        actualContent = extractContent(actual.get(), type);
        actualContentType = type;
    }


    public MatrixAssert<TElement> hasContent(TElement[][] expectedContent)
    {
        assertThat(actualContent).isDeepEqualTo(expectedContent);

        return this;
    }

    public MatrixAssert<TElement> hasSize(int rows, int cols)
    {
        var gotSize = actual.size();

        assertThat(gotSize).containsExactly(rows, cols);
        assertThat(actual.rows()).isEqualTo(gotSize[0]);
        assertThat(actual.cols()).isEqualTo(gotSize[1]);

        return this;
    }

    public MatrixAssert<TElement> isTheSameMatrixAs(TElement[][] expectedContent)
    {
        hasContent(expectedContent);
        hasSize(expectedContent.length, expectedContent.length == 0 ? 0 : expectedContent[0].length);

        return this;
    }

    @SuppressWarnings("unchecked")
    public MatrixAssert<TElement> isEmpty()
    {
        hasSize(0, 0);
        hasContent((TElement[][]) Array.newInstance(actualContentType, 0, 0));

        return this;
    }
}
