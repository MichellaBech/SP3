package src;

import java.util.ArrayList;

public class User {

    final String username;
    final String password;
    TextUI ui = new TextUI();
    FileIO io = new FileIO();

    Menu menu = new Menu();
   ArrayList<User> login = new ArrayList<>();

   public User(String username, String password)
   {
       this.username = username;
       this.password = password;
   }
    public void createLogin()
    {
            String inputUsername = ui.getInput("Please write a username: ");
            String inputPassword = ui.getInput("Please write a password: ");
            User user = new User(inputUsername, inputPassword);
            login.add(user);
            io.saveLogin(login);
    }

    public void login() {
            String inputUsername = ui.getInput("Please write your username: ");
            String inputPassword = ui.getInput("Please write your password: ");
            if (io.readFile(inputUsername, inputPassword, "data.txt")) {
                ui.displayMessage("Welcome back!");
            }
        menu.mainMenu();
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
}
