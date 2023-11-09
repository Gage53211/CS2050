/**********************
* Name: Gage Mather
* Assignment: Program8
***********************/

import java.io.*;

public class Program8
{
    
   //function is needed as Math.pow() returns double
   public static long maxNodes (long height)
   {
       long nodes = 2;
       
       for(int x = 1; x < height; x++)
       {
           nodes = nodes * 2;
       }
       
       return nodes - 1;
   }
    
    
    
   public static void main (String []args)
   {
   
   String dracula = "";
   String line = "";
   String[] splitDrac;
   long maxNodes;
   
   BstTree tree = new BstTree();
   Node root;
   
   
      try
      {
      
         BufferedReader reader = new BufferedReader(new FileReader ("dracula.txt"));
         BufferedWriter writer = new BufferedWriter(new FileWriter ("analysis.txt"));   
         
            while ((line = reader.readLine()) != null) // checks to see if the next line is null
            {
                  dracula = dracula + line + " "; // converts the text file into a string
            } 
            
           
         reader.close();
         
         //word seperation
         dracula = dracula.toLowerCase();
         dracula = dracula.replaceAll("[”“”“‘’]", "");
         dracula = dracula.replaceAll("[æ”’]", "");
         dracula = dracula.replaceAll("--", " ");
         dracula = dracula.replaceAll("-", " ");
         dracula = dracula.replaceAll("\\d+", ""); // removing digits
         dracula = dracula.replaceAll("\\p{Punct}", ""); // removing remaining punctuation
  
         splitDrac = dracula.split("\\s" ,0); // splits each word at white space
         root = new Node (splitDrac[0]);
  
            for (String s : splitDrac) 
            {
              
              if (!(s.equals("   ") && s.equals(" ")))
              {
                  tree.insert (new Node (s), root); 
              }
              
            }
            
            
         writer.write ("total number of nodes in tree: " + tree.getCount() + "\n");
         writer.write ("height of tree: " + tree.findHeight(root) + "\n");
         writer.write ("number of possible nodes in tree: " + maxNodes((long) tree.findHeight(root)));
         writer.close();
         //tree.postOrder(root);
                
      }
      
      catch (IOException e)
      {
         System.out.println ("an IOException has occured");
      }
   
   
   }


}
