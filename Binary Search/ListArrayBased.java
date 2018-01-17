/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 1a
 * Status: Complete and thoroughly tested
 * Last update: 02/3/17
 * Submitted:  02/6/17
 * Comment: test suite and sample run attached
 * @author: Philip Quinn
 * @version: 2017.02.03
 */

public class ListArrayBased<T> implements ListInterface<T>
{

    protected T[] items;  // an array of list items
    protected int numItems;  // number of items in list

    public ListArrayBased()
    {
        items = (T[]) new Object[3];
        numItems = 0;
    }  // end default constructor

    public boolean isEmpty()
    {
        return (numItems == 0);
    } // end isEmpty

    public int size()
    {
        return numItems;
    }  // end size

    public void removeAll()
    {
        // Creates a new array; marks old array for
        // garbage collection.
        items = (T[]) new Object[3];
        numItems = 0;
    } // end removeAll

    public void add(int index, T item)throws  ListIndexOutOfBoundsException
    	    {
    	        if (numItems == items.length)//.length allows this to be extendable.
    	        {
    	            throw new ListIndexOutOfBoundsException("ListException on add");
    	        }  // end if
    	        if (index >= 0 && index <= numItems)
    	        {
    	            // make room for new element by shifting all items at
    	            // positions >= index toward the end of the
    	            // list (no shift if index == numItems+1)
    	            for (int pos = numItems-1; pos >= index; pos--)  //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
    	            {
    	                items[pos+1] = items[pos];
    	            } // end for
    	            // insert new item
    	            items[index] = item;
    	            numItems++;
    	        }
    	        else
    	        {
    	            // index out of range
    	            throw new ListIndexOutOfBoundsException(
    	                "ListIndexOutOfBoundsException on add");
    	        }  // end if
    	    } //end add

    	    public T get(int index)throws ListIndexOutOfBoundsException
    	    {
    	        if (index >= 0 && index < numItems)
    	        {
    	            return items[index];
    	        }
    	        else
    	        {
    	            // index out of range
    	            throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on get");
    	        }  // end if
    	    } // end get

    	    public void remove(int index)throws ListIndexOutOfBoundsException
    	    {
    	        if (index >= 0 && index < numItems)
    	        {
    	            // delete item by shifting all items at
    	            // positions > index toward the beginning of the list
    	            // (no shift if index == size)
    	            for (int pos = index+1; pos < numItems; pos++) //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException

    	            {
    	                items[pos-1] = items[pos];
    	            }  // end for
    	            items[numItems-1] = null;//Used to remove memory leak
    	            numItems--;
    	        }
    	        else
    	        {
    	            // index out of range
    	            throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on remove");
    	        }  // end if
    	    } //end remove
    	}
