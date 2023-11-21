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
        return watchedMedia;
    }

    public HashSet<Media> getSavedMedia(User user)
    {
        return savedMedia;
    }

    public String toString()
    {
        return "Username: " + getUsername() +  " " + "Password: " + getPassword();
    }

}
