package oop.labs.lab2;

public interface Matrix<TElement>
{
    int[] size();

    int rows();
    int cols();

    Integer get(int row, int col);
    Matrix<TElement> set(int row, int col, TElement value);

    Iterable<Integer> row(int index);
    Iterable<Integer> col(int index);

    Matrix<TElement> fillRow(int index, Iterable<TElement> source);
    Matrix<TElement> fillCol(int index, Iterable<TElement> source);

    Matrix<TElement> fillRow(int index, int[] source);
    Matrix<TElement> fillCol(int index, int[] source);

    Matrix<TElement> fill(int[][] source);
    <TRow extends Iterable<TElement>> Matrix<TElement> fill(Iterable<TRow> source);
}
