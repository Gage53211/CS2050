/**********************
* Name: Gage Mather
* Assignment: Program3
***********************/

public class ArrayStackClass 
{

   public String[] elements;
   public int numOfElements;
   public int stackSize;
   
   //Stack constructor
   public ArrayStackClass (int numOfElements)
   {
      this.numOfElements = numOfElements;
      elements = new String[numOfElements];
      stackSize = 0;
   }
   
   //push adds an element to the top of the array
   public void push (String element)
   {
      if (stackSize < (elements.length))
      {  
         elements[stackSize] = element;
         stackSize++;
      }
   }
   
   //test method
   public void printContents()
   {
      for (int i = 0; i < elements.length; i++)
      {
         if (elements[i] != null)
         System.out.println (elements[i]);
      }
   }

   //pop removes the top most element from the array
   public String pop()
   {
      String hold = "";
      
         if (stackSize > 0)
         {
            stackSize--;
            
            hold = elements[stackSize];
            elements[stackSize] = null;
            
            return hold;
         }
         
     return hold; 
   }
   
   //empty nullifys all elements in the stack and sets the index to 0
   public void empty()
   {
      
      stackSize = 0;
      
      for (int i = 0; i < elements.length; i++)
      {
         elements[i] = null;
      }
   
   }
   
   //returns the size of the stack
   public int size()
   {
      return stackSize;
   }
   
   //returns the string at the top of the stack
   public String peek()
   {
      if (stackSize > 0)
      { 
         return elements[stackSize - 1];
      }
      
     return "no items in stack";
   }
   
}