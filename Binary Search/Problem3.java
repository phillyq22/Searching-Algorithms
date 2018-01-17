import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3 {

        private static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

        public static void main(String args[])throws IOException
        {
        		AscendinglyOrderedStringList aosl = new AscendinglyOrderedStringList();
                String obj = "";
                int index;
                int choice = 0;
        do {
            System.out.print("1. Insert specified item into list.\n2. Remove item in specified position in the list.\n3. Search list for specified item.\n4. Clear list.\n5. Display Content of list.\n6. Exit.\nMake your selection now: ");
            choice = Integer.parseInt(stdin.readLine());
            System.out.println(choice);
            switch(choice){
                        case(1):   System.out.print("You are now inserting an item into the list.\nEnter item: ");
                                   obj = stdin.readLine();
                                   System.out.println(obj);
                                   try
                                   {
                                      aosl.add(obj);
                                      System.out.println("Item " + obj + " inserted in the ordered list.");
                                   }
                                   catch(ListIndexOutOfBoundsException e)
                                   {
                                      System.out.println("Position specified is out of range!");
                                   }
                                   break;
                        case(2):   System.out.print("You are now removing an item from the list.\nEnter index: ");
                                   index = Integer.parseInt(stdin.readLine());
                                   System.out.println(index);
                                   if(index == aosl.items.length)
                                   {
                                        System.out.println("Position specified is out of range!");
                                   }
                                   else
                                   {
                                        aosl.remove(index);
                                        System.out.println("Item removed from position " + index + " in the list.");
                                   }
                                   break;

                        case(3):	System.out.print("Enter the item that you would like to search for: ");
                        			obj = stdin.readLine();
                                    System.out.println(obj);
                                    if(aosl.size() > 0)
                                    {
                                        index = aosl.search(obj);
                                    	if(index < 0)
                                        {
                                        	System.out.println("Unsuccessful search. Item not found in list.");
                                        }
                                        else
                                        {
                                        	index++;
                                        	System.out.println("Successful search, item found at position " + (--index) + ".");
                                        }
                                    }
                                    else
                                    {
                                    	System.out.println("List is empty.");
                                    }
                                    break;
                        case(4):	aosl.clear();
                        			System.out.println("List cleared.");
                        			break;
                        case(5):   if(aosl.isEmpty())
                        			{
                            			System.out.println("List is empty");
                        			}
                        			else
                        			{
                        				System.out.println("List of size " + aosl.size() + " has the following items: " + aosl.toString());
                        			}
                        			break;
                        default:

            }
        }while(choice != 6);
        System.out.println("Exiting program...Good Bye");
    }
}

               