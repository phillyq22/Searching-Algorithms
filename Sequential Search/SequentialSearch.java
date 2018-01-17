import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SequentialSearch {

        private static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

        public static void main(String args[])throws IOException
        {
        		ListArrayBasedPlus<String> labp = new ListArrayBasedPlus<String>();
                String obj = "";
                int index;
                int choice = 0;
        do {
            System.out.print("1. Insert item to list.\n2. Remove item from list.\n3. Get item from list.\n4. Search for a specified item in the list.\n5. Clear list.\n6. Print size and content of list.\n7. Exit program.\nMake your selection now: ");
            choice = Integer.parseInt(stdin.readLine());
            System.out.println(choice);
            switch(choice){
                        case(1):   System.out.print("You are now inserting an item into the list.\nEnter item: ");
                                       obj = stdin.readLine();
                                       System.out.println(obj);
                                       System.out.print("Enter position to insert item in: ");
                                       index = Integer.parseInt(stdin.readLine());
                                       System.out.println(index);
                                       try
                                       {
                                    	   labp.add(index, obj);
                                           System.out.println("Item " + obj + " inserted in position " + index + " in the list.");
                                       }
                                       catch(ListIndexOutOfBoundsException e)
                                       {
                                           System.out.println("Position specified is out of range!");
                                       }
                                       break;
                        case(2):   System.out.print("You are now removing an item from the list.\nEnter index: ");
                                   index = Integer.parseInt(stdin.readLine());
                                   System.out.println(index);
                                   try{
                                	   if(index == labp.size())
                                       {
                                            System.out.println("Position specified is out of range!");
                                       }
                                       else
                                       {
                                    	    obj = labp.get(index);
                                            labp.remove(index);
                                            System.out.println("Item " + obj + " removed from position " + index + " in the list.");
                                       }
                                   }
                                   catch(ListIndexOutOfBoundsException e)
                                   {
                                	   System.out.println("No item found at index " + index + ".");
                                   }
                                   break;
                        case(3):   System.out.print("Enter position to retrieve item from: ");
                                   index = Integer.parseInt(stdin.readLine());
                                   System.out.println(index);
                                   try
                                   {
                                	   if(index == labp.items.length)
                                       {
                                           System.out.println("Position specified is out of range!");
                                       }
                                       else
                                       {
                                               System.out.println("Item " + labp.get(index) + " retrieved from position " + index + " in the list.");
                                       }
                                   }
                                   catch(ListIndexOutOfBoundsException e)
                                   {
                                	   System.out.println("Not a valid index.");
                                   }
                                   break;
                        case(4):	System.out.print("Enter the item that you would like to search for: ");
                        			obj = stdin.readLine();
                                    System.out.println(obj);
                                    int size = labp.size();
                                    int location = -1;
                                    boolean found = false;
                                    for(int i = 0; i < size && !found; i++)
                                    {
                                    	Object curr = labp.get(i);
                                    	if(curr.equals(obj))
                                    	{
                                    		location = i; 
                                    		found = true;
                                    	}
                                    }
                                    if(found)
                                    {
                                    	System.out.println("Successful search, item found at position " + location + ".");
                                    }
                                    else
                                    {
                                    	System.out.println("Unsuccessful search.");
                                    }
                                    break;
                        case(5):   labp.removeAll();
                                       break;
                        case(6):   if(labp.isEmpty())
                                           {
                                               System.out.println("List is empty");
                                           }
                                           else
                                           {
                                               System.out.println("List of size " + labp.size() + " has the following items: " + labp.toString());
                                           }
                                           break;
                        default:

            }
        }while(choice != 7);
        System.out.println("Exiting program...Good Bye");
    }
}

               