
public class AscendinglyOrderedStringList implements AscendinglyOrderedStringListInterface{

	protected String[] items = new String[3];
	protected int numItems = 0;
	
	public boolean isEmpty() {
        return (numItems == 0);
	}

	public int size() {
		return numItems;
	}

	public void add(String item) throws ListIndexOutOfBoundsException {
		//get index from search
		if (numItems == items.length)//.length allows this to be extendable.
        {
            resize();
        }  // end if
		int index = search(item);
		if(index < 0)
		{
			index = (index+1)*-1;
		}
		else//just added
		{
			throw new ListIndexOutOfBoundsException("Items already exists");
		}
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
            throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on add");
        }  // end if
	}

	public String get(int index) throws ListIndexOutOfBoundsException {
		if (index >= 0 && index < numItems)
        {
            return items[index];
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on get");
        }  // end if
	}

	public void remove(int index) throws ListIndexOutOfBoundsException {
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
	}

	public int search(String item) 
	{
		int returnInt = -1;
		if(numItems == 0)
		{
			return returnInt;
		}
		if(numItems == 1)
		{
			returnInt = 1;
		}
		int low = 0;
		int high = (numItems - 1);
		boolean found = false;
		while(low <= high && !found)
		{
			int midIndex = (high+low)>>1;
			String midKey = items[midIndex];
			if(item.compareTo(midKey)==0)
			{
				returnInt = midIndex;
				found = true;
			}
			else if(midKey.compareTo(item) > 0)
			{
				high = midIndex - 1;
			}
			else
			{
				low = midIndex + 1;
			}
			if(low > high)
			{
				returnInt = -(low+1);
			}
		}
		return returnInt;
	}

	public void clear() 
	{
		items = new String[3];
		numItems = 0;
	}

	private void resize()
    {
        String[] newArray = new String[items.length*2];
        for(int i = 0; i < items.length; i++)
        {
            newArray[i] = items[i];
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
