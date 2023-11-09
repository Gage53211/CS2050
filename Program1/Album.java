/********************************************************************
 * Album Creator
 *
 * Class Name: Album
 * Author: Gage Mather
 * Description: this application serves as the driver for the Album class
 *******************************************************************/
public class Album {

    private String title;
    private String performer;
    private String genre;
    private int numOfSongs;
    public Album ()
    {
        title = "Renaissance";
        performer = "Beyonce";
        genre = "easy listening";
        numOfSongs = 10;
    }

    public Album (String title, String performer, String genre, int numOfSongs)
    {
        this.title = title;
        this.performer = performer;
        this.genre = genre;
        this.numOfSongs = numOfSongs;
    }

    //setter methods
    //----------------------------------------------------------------------------

    public void setTitle (String title)
    {
        this.title = title;
    }

    public void setPerformer (String performer)
    {
        this.performer = performer;
    }

    public void setGenre (String genre)
    {
        this.genre = genre;
    }

    public void setNumOfSongs (int numOfSongs)
    {
        this.numOfSongs = numOfSongs;
    }

    //getter methods
    //----------------------------------------------------------------------------
    public String getTitle ()
    {
        return title;
    }

    public String getPerformer ()
    {
        return performer;
    }

    public String getGenre ()
    {
        return genre;
    }

    public int getNumOfSongs ()
    {
        return numOfSongs;
    }

    //isLong method
    //----------------------------------------------------------------------------

    public boolean isLong ()
    {
        return numOfSongs > 50;
    }

    //toString method
    //----------------------------------------------------------------------------

    public String toString() {
        return  "\n---------------------------" +
                "\nTitle: " + title +
                "\nPerformer: " + performer +
                "\nGenre: " + genre +
                "\nNumber of songs: " + numOfSongs +
                "\nIs Long?: " + isLong() +
                "\n---------------------------\n";
    }
}
