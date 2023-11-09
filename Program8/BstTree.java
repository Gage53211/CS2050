/**********************
* Name: Gage Mather
* Assignment: Program8
***********************/

import java.util.*;

public class BstTree
{ 

   public int count;
 
 
   public BstTree ()
   {
      count = 0;
   }
   
   public void insert(Node newNode, Node root)
   {
      
      if (root == null) // sets the root to the new node if there isnt a root
      {
         root = newNode;  
         count++;
         return; 
      }  
      
      if (newNode.data.compareTo (root.data) < 0) //data is less than
      {
         if (root.left == null) 
         {
            root.left = newNode;
            count++;
            return;
         }
         
         insert(newNode, root.left); // recursive call for left side traversal
      }
      
      if (newNode.data.compareTo (root.data) > 0) // data is greater than
      {
         if (root.right == null)
         {
            root.right = newNode;
            count++;
            return;
         }
         
         insert(newNode, root.right); // recursive call for right side traversal
      }
      
      if (newNode.data == root.data)
      {
         return;
      }
     
   }
   
   //debug function
   void postOrder(Node root) {
    
    if (root == null)
    {
      return;
    }  
      
    postOrder(root.left); //traverse left subtree
    postOrder(root.right); //traverse right subtree

    System.out.println (root.data);
  }
   
  public int findHeight(Node root) 
  {
    
      if (root == null) 
      {
        return -1;
      }

      int left = findHeight(root.left);
      int right = findHeight(root.right);

      if (left > right) 
      {
        return left + 1;
      } 
    
        else 
        {
           return right + 1; 
        }
        
  }
   
   
  public int getCount ()
  {
    return count; 
  }
   
}
