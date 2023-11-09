/**********************
* Name: Gage Mather
* Assignment: Program4
***********************/

class Node 
{ 
   public String data;
   public Node next;   

}

public class MyLinkedStack
{
    
   private Node head;
   private int size;
   
   public MyLinkedStack ()
   {
      size = 0;
   }
   
   public void push (String data)
   {
      
      //creates new Node object
      Node newNode = new Node();
      newNode.data = data;
      
      //sets new node object to head of list
      newNode.next = head;
      head = newNode;
      
      size++;
          
   }
   
   public String pop ()
   {
      String popped = "";
      
      if (size == 0)
      {
         popped = "";
      }
      
      
      if (size > 0)
      {
         
         popped = head.data;
         
         //head now points to previous object
         head = head.next;
         size--;
      }
         
      return popped; 
   }
   
   public String peek ()
   {
      if (size != 0)
      {
         String peek = head.data;
         return peek;
      }
      
      return "stack is empty";
   }
   
   public int size ()
   {
      return size;
   }
   
}