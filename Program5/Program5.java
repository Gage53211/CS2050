/**********************
* Name: Gage Mather
* Assignment: Program4
***********************/

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Program5
{
    
   public static int precedence (String character)
   {
   
      switch (character)
      {
         
         case "*","/","%"         :  return 2;
         case "+","-"             :  return 1;
         case ".","(",")"," "     :  return 0;
         
         case "1","2","3",
              "4","5","6",
              "7","8","9","0"     :  return 0;
         
      }
    
    return -1;
    
   }
   
   public static String InfixToPostfix (String infix)
   { 
      
      Stack<String> stack = new Stack<String>();
      
      String postfix = "";
      String letter;
      String hold = "";
      String postfixFormated;
      
      int parenCount = 0;
      boolean invalidOpp = false;
      
 
      //logic for determining if current selected character is an operator
      //------------------------------------------------------------------
      
      for (int i = 0; i < infix.length(); i++)
      {  
      
      letter = infix.substring (i, i + 1);
         
         if (precedence(letter) < 0)
         {
            invalidOpp = true;
         }
               
            else if (precedence(letter) > 0)
            {   
               while((stack.size() > 0 && precedence(letter) <= precedence(stack.peek())))
               {  
                  postfix = postfix + stack.pop();
               }
         
               try
               {
               
                  if (precedence(letter) > precedence(stack.peek()))
                  { 
                     stack.push(letter);
                  }
               
               }
               
               catch (Exception e)
               {
                  stack.push(letter);
               }
                  
            } 
      
      //-----------------------------------------------------------------
               
 
      //parethesis logic
      //-----------------------------------------------------------------    
 
      else if(letter.equals(")"))
      {
               
      parenCount++;
      hold = stack.pop();
              
         while(!hold.equals("("))
         {
            postfix = postfix + hold;
            hold = stack.pop();
         }
      }
            
      else if(letter.equals("("))
      {  
         parenCount++;
         stack.push(letter);
      }       
            
      //-----------------------------------------------------------------           
      
      //formatting
      //----------------------------------------------------------------- 
      
         else //if the operand is not an operator then print
         {
            postfix = postfix + letter;
         }  
         
      } //end of for loop
      
      for (int x = 0; x <= stack.size() ; x++) 
      {
           if (!stack.isEmpty())
           {
               postfix = postfix + stack.pop(); 
           }
      }
      
      if (invalidOpp == true)
      {
         postfix = "Invalid Character";
      }
 
         else if (parenCount % 2 != 0)
         {
            postfix = "Unmatched Parenthesis";
         }
      
      postfix = postfix.replaceAll("  ", " ");
         
      //----------------------------------------------------------------- 
            
      return postfix;
      
   }
   
   
   public static void main (String []args)
   {
      
      String infix = "";
      String postfix;
      
      try
      {
      
      BufferedReader reader = new BufferedReader(new FileReader ("Program3.txt")); 
      BufferedWriter writter = new BufferedWriter(new FileWriter ("Program5.out")); 

  
         while (infix != null)
         {
                   
           infix = reader.readLine();
           
            if (infix != null)
            {
                postfix = InfixToPostfix (" " + infix);
                writter.write (infix + " -> " + postfix + "\n");
            }
                   
         }
        
      writter.close();  
      reader.close();
      
      }
      
      catch (IOException e)
      {
        System.out.println ("IOException");
      }
        
   } 
         
}
            