/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 1b
 * Status: Complete and thoroughly tested
 * Last update: 02/3/17
 * Submitted:  02/6/17
 * Comment: test suite and sample run attached
 * @author: Philip Quinn
 * @version: 2017.02.03
 */

public class ListArrayBasedPlus<T> extends ListArrayBased<T> {

    public ListArrayBasedPlus()
    {
        super();
    }

    public void add(int index, T obj)
    {
        if(numItems == items.length)
        {
            resize();
        }
        super.add(index, obj);
    }

    private void resize()
    {
        T[] newArray = (T[])new Object[items.length*2];
        for(int i = 0; i < items.length; i++)
        {
            newArray[i] = items[i];
        }
        items = newArray;
    }

    public void reverse()
    {
        T[] newArray = (T[])new Object[items.length];
        for(int i = numItems-1; i >= 0; i--)
        {
            newArray[numItems-i-1] = items[i];
        }
        items = newArray;
    }

    public String toString()
    {
        String returnString = "";
        for(int i = 0; i < numItems; i++)
        {
            returnString += (items[i] + " ");
        }
        return returnString;
    }
}
