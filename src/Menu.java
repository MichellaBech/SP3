package src;

import java.util.ArrayList;
import java.util.HashSet;

public class Menu {

    TextUI ui = new TextUI();
    ArrayList<User> login = new ArrayList<>();
    FileIO io = new FileIO();




    public Menu()
    {
    }

    //Starts the program, where it reads the users answer, login, create account or something went wrong
    public void startMenu() {
        io.scanMedia("100bedstefilm.txt");
        io.scanMedia("100bedsteserier.txt");
        Boolean validInpit = false;
        String password = "";
        String username = "";
        User user = new User(username, password);

        while(!validInpit){
        String input = String.valueOf(ui.getInput("Hello, welcome to CHILL! Do you want to create account or login?"));

            if(input.equalsIgnoreCase("create account")) {
            createLogin();
            validInpit = true;
        } else if (input.equalsIgnoreCase("login")) {
            login();
            validInpit = true;
        } else {
                ui.displayMessage("Something went wrong, please try again");
            }
        }
    }


    public void mainMenu()
    {
        ui.displayMessage("Search for a specific movie:");
        ui.displayMessage("Choose category: ");
        ui.displayMessage("Movies you've seen: ");
        ui.displayMessage("Saved movies: ");
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
        mainMenu();
    }

    public void movieSearch()
    {

    }

    //Make a method call from FileIO
    public void chooseCategorie()
    {

    }

    public void playMedia()
    {

    }

    public void saveMedia()
    {

    }


    public void selectMedia()
    {

    }


    public void getRating()
    {

    }
}
