package oop.labs.lab2;

public interface Matrix<TElement>
{
    int[] size();

    int rows();
    int cols();

    TElement get(int row, int col);
    Matrix<TElement> set(int row, int col, TElement value);

    Iterable<Integer> row(int index);
    Iterable<Integer> col(int index);

    Matrix<TElement> fillRow(int index, Iterable<TElement> source);
    Matrix<TElement> fillCol(int index, Iterable<TElement> source);

    Matrix<TElement> fillRow(int index, TElement[] source);
    Matrix<TElement> fillCol(int index, TElement[] source);

    Matrix<TElement> fill(Integer[][] source);
    <TRow extends Iterable<TElement>> Matrix<TElement> fill(Iterable<TRow> source);
}
