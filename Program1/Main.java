import java.util.*;

/********************************************************************
 * Album Creator
 *
 * Class Name: Main
 * Author: Gage Mather
 * Description: this application serves as the driver for the Album class
 *******************************************************************/


public class Main {

    public static void main(String[] args) {

        String title;
        String performer;
        String genre;
        int numOfSongs;
        int selection = 0;

        Scanner input = new Scanner (System.in);
        Album[] albums = new Album[3];

        System.out.println ("\n-----------------------------------------------");
        System.out.println ("Album Creator\nDescription: create up to 3 albums");
        System.out.println ("-----------------------------------------------\n");


        for (int i = 0; i < 3; i++ )
        {


            System.out.println ("--Album " + (i + 1) + "--");
            System.out.println ("Please enter in the title of this album:");
            title = input.nextLine();

            if (i > 0)
            {
                title = input.nextLine(); //statement needed in order for scanner to work correctly
            }

            System.out.println ("\nPlease enter in the performer of this album:");
            performer = input.nextLine();


            System.out.println ("\nPlease select the genre of this album (will default to option 2 if input is greater than 5):");
            System.out.println ("1. hip hop\n2. easy listening\n3. orchestral\n4. your parents\n5. theatre");


            switch (selection)
            {
                case 1 -> genre = "hip hop";
                case 2 -> genre = "easy listening";
                case 3 -> genre = "orchestral";
                case 4 -> genre = "your parents";
                case 5 -> genre = "theatre";
                default -> genre = "easy listening";

            }

            try
            {
                selection = input.nextInt();
            }
                catch (InputMismatchException e)
                {
                    input.next();
                    selection = 2;
                    System.out.println("\n--input is not a number, defaulting to easy listening--");
                }

            System.out.println ("\n" + "Please enter in the number of songs in this album (cant be below 10 songs):");

            try
            {
                numOfSongs = input.nextInt();
            }
                catch (InputMismatchException e)
                {
                    input.next();
                    numOfSongs = 10;
                    System.out.println("\n--input is not a number, defaulting to 10 songs--");
                }

            if (numOfSongs < 10)
            {
                System.out.println ("\n--Number of songs cannot be below 10--");
                numOfSongs = 10;
            }

            albums[i] = new Album(title,performer,genre,numOfSongs);
            System.out.println (albums[i].toString());

        }
    }
}