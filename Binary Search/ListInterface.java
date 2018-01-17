/*
 * Purpose: Data Structure and Algorithms Lab 1 Problem 1a
 * Status: Complete and thoroughly tested
 * Last update: 02/3/17
 * Submitted:  02/6/17
 * Comment: test suite and sample run attached
 * @author: Philip Quinn
 * @version: 2017.02.03
 */

public interface ListInterface<T>
{
    boolean isEmpty();
    int size();
    void add(int index, T item)
    throws ListIndexOutOfBoundsException;
    Object get(int index)
    throws ListIndexOutOfBoundsException;
    void remove(int index)
    throws ListIndexOutOfBoundsException;
    void removeAll();
}  // end ListInterface
