package src;

import java.util.ArrayList;
import java.util.HashSet;

public class User {

    private String username;
    private String password;

    private HashSet<Media> watchedMedia = new HashSet<Media>();
    private HashSet<Media> savedMedia = new HashSet<Media>();

   public User(String username, String password)
   {
       this.username = username;
       this.password = password;
   }


    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public HashSet<Media> getWatchedMedia()
    {
        TextUI ui = new TextUI();
        ui.displayMessage("Your watched Media: " + watchedMedia);
        return watchedMedia;
    }

    public HashSet<Media> getSavedMedia()
    {
        return savedMedia;
    }

}
