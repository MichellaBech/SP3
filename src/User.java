package src;

import java.util.ArrayList;

public class User {

    final String username;
    final String password;
    TextUI ui = new TextUI();
    FileIO io = new FileIO();
   ArrayList<User> login = new ArrayList<>();

   public User(String username, String password)
   {
       this.username = username;
       this.password = password;
   }
    public void createLogin()
    {
        if (ui.getInput("Hello, welcome to CHILL! Do you want to create account or login?").equalsIgnoreCase("create account")){
            String inputUsername = ui.getInput("Please write a username: ");
            String inputPassword = ui.getInput("Please write a password: ");
            User user = new User(inputUsername, inputPassword);
            login.add(user);
            io.saveLogin(login);
        } else {
            login();
        }
    }

    public void login() {
        if (ui.getInput("Type Y to proceed to login").equalsIgnoreCase("Y")) {
            String inputUsername = ui.getInput("Please write your username: ");
            String inputPassword = ui.getInput("Please write your password: ");
            if (io.readFile(inputUsername, inputPassword, "data.txt")) {
                ui.displayMessage("Welcome back!");
            }
        }
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
