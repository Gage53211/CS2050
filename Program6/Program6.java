/**********************
* Name: Gage Mather
* Assignment: Program6
***********************/

import java.util.*;
import java.io.*;

public class Program6
{

   public static int[] intBubbleSort (int[] array)
   {
      int[] sortedArray = array;
      int hold = 0;
      
      for (int passes = 0; passes < sortedArray.length; passes++) // how many passes the algorithm should make
      {
      
         for (int item = 0; item < sortedArray.length; item++) // indexing through array
         {
         
            if ((item + 1) < sortedArray.length && sortedArray[item] > sortedArray[item + 1])
            {
               // swaps the selected item and the item next to it
               hold = sortedArray[item + 1];
               sortedArray[item + 1] = sortedArray[item];
               sortedArray[item] = hold;
            }
         
         }   
      
      }
      
      return sortedArray;
   }
   
   public static int[] intSelectionSort (int[] array)
   {
    
      int[] sortedArray = array;
      int hold = 0;
      int smallestIndex;
         
      for (int selected = 0; selected < sortedArray.length; selected++) // selects an item in the list
      {
         
         smallestIndex = selected;
         
         for (int j = selected; j < sortedArray.length; j++) 
         {
       
           
           if (!(sortedArray[selected] < sortedArray[j])) // finds index of smallest item
           {
               
               smallestIndex = j;
      
               // swapping selected item and the smallest item
               hold = sortedArray[selected];
               sortedArray[selected] = sortedArray[smallestIndex];
               sortedArray[smallestIndex] = hold;
               
           }
           
          
         }
        
      
      }
      
      return sortedArray;
      
   }
   
   public static String[] stringBubbleSort (String[] array)
   {
      String[] sortedArray = array;
      String hold = "";
      
      for (int passes = 0; passes < sortedArray.length; passes++) // how many passes the algorithm should make
      {
      
         for (int item = 0; item < sortedArray.length; item++) // indexing through array
         {
         
            if ((item + 1) < sortedArray.length && sortedArray[item].compareTo(sortedArray[item + 1]) < 0)
            {
               // swaps the selected item and the item next to it
               hold = sortedArray[item + 1];
               sortedArray[item + 1] = sortedArray[item];
               sortedArray[item] = hold;
            }
         
         }   
      
      }
      
      return sortedArray;
   }
   
   public static String[] stringSelectionSort (String[] array)
   {
    
      String[] sortedArray = array;
      String hold = "";
      int smallestIndex;
         
      for (int selected = 0; selected < sortedArray.length; selected++) // selects an item in the list
      {
         
         smallestIndex = selected;
         
         for (int j = selected; j < sortedArray.length; j++) 
         {
       
           
           if (sortedArray[j].compareTo(array[selected] ) < 0) // finds index of smallest item
           {
               
               smallestIndex = j;
      
               // swapping selected item and the smallest item
               hold = sortedArray[selected];
               sortedArray[selected] = sortedArray[smallestIndex];
               sortedArray[smallestIndex] = hold;
               
           }
           
          
         }
        
      
      }
      
      return sortedArray;
      
   }

   public static void main (String []args)
   {
   
   int[] intBubbleSortArray = new int[20000];
   int[] intSelectionSortArray = new int[20000];
   String[] stringBubbleSortArray = new String[10000];
   String[] stringSelectionSortArray = new String[10000];
  
   int parsedInteger;
   String readString;
   
   double starttime;
   double endtime;
   final double Billion = 1000000000.0;
   
   ArrayList <Integer> arrayListArray = new ArrayList <Integer> ();
   ArrayList <String> StringArrayList = new ArrayList <String> ();
  
      try
      {
         BufferedReader numbersReader = new BufferedReader(new FileReader ("NumbersInFile.txt"));
         BufferedReader stringsReader = new BufferedReader(new FileReader ("StringsInFIle.txt"));
         BufferedWriter writer = new BufferedWriter(new FileWriter ("results.txt"));
         
            for (int i = 0; i < 20000; i++)
            {
               parsedInteger = Integer.parseInt(numbersReader.readLine());
          
               intBubbleSortArray[i] = parsedInteger;
               intSelectionSortArray[i] = parsedInteger;
               arrayListArray.add(parsedInteger);   
            }
            
            for (int i = 0; i < 10000; i++)
            {
               readString = stringsReader.readLine();
              
               StringArrayList.add(readString);
               stringBubbleSortArray[i] = readString;
               stringSelectionSortArray[i] = readString;
            }

         numbersReader.close();
         stringsReader.close();
         
         // time calculation for Number bubble sort
         starttime = System.nanoTime();
         intBubbleSortArray = intBubbleSort(intBubbleSortArray);
         endtime = System.nanoTime();
   
         writer.write("Number bubble sort took " + (endtime - starttime) / Billion + " seconds to finish with 20,000 integers");
         
         // time calculation for Number selection sort
         starttime = System.nanoTime();
         intSelectionSortArray = intSelectionSort(intSelectionSortArray);
         endtime = System.nanoTime();
 
         writer.write ("\nNumber selection sort took " + (endtime - starttime) / Billion + " seconds to finish with 20,000 integers");
         
         // time calculation for String selection sort
         starttime = System.nanoTime();
         stringBubbleSortArray = stringBubbleSort(stringBubbleSortArray);
         endtime = System.nanoTime();
 
         writer.write ("\nString bubble sort sort took " + (endtime - starttime) / Billion + " seconds to finish with 10,000 Strings");
         
         // time calculation for String bubbleSort sort
         starttime = System.nanoTime();
         stringSelectionSortArray = stringSelectionSort (stringSelectionSortArray);
         endtime = System.nanoTime();
 
         writer.write ("\nString selection sort took " + (endtime - starttime) / Billion + " seconds to finish with 10,000 Strings");
         
         // time calculation for String system sort
         starttime = System.nanoTime();
         Collections.sort (StringArrayList);
         endtime = System.nanoTime();
 
         writer.write ("\nString system sort took " + (endtime - starttime) / Billion + " seconds to finish with 10,000 Strings");
         
         writer.close();
           
      }
         
      catch (IOException e)
      {
          System.out.println ("an IOException has occured");
      }
  
  
   }

}