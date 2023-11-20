package src;

public class Menu {

    TextUI textUI = new TextUI();


    public Menu()
    {

    }
    public void startMenu()
    {
        String password = "";
        String username = "";
        User user = new User(username, password);
        user.createLogin();

    }
}
