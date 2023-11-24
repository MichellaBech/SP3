package src;

import java.util.HashSet;

public class User {

    private String username;
    private String password;

    private HashSet<String> watchedMedia = new HashSet<String>();
    private HashSet<String> savedMedia = new HashSet<String>();

   public User(String username, String password)
   {
       this.username = username;
       this.password = password;
   }

    public void saveMedia(String media, User user) {
       TextUI ui = new TextUI();
        FileIO io = new FileIO();
        String saveMedia = String.valueOf(io.searchInFile("100bedstefilm.txt", media));
        String savesMedia = String.valueOf(io.searchInFile("100bedsteserier.txt", media));
        savedMedia.add(saveMedia);
       ui.displayMessage(String.valueOf(getSavedMedia(user)));
    }


    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public HashSet<String> getWatchedMedia(User user)
    {
        return watchedMedia;
    }

    public HashSet<String> getSavedMedia(User user)
    {
        TextUI ui = new TextUI();
        ui.displayMessage("Your saved Media List: ");
        ui.displayMessage("" + savedMedia);
        return savedMedia;
    }

    public String toString()
    {
        return "Username: " + getUsername() +  " " + "Password: " + getPassword();
    }



}
