package src;

import java.util.ArrayList;
import java.util.HashSet;

public class Menu {

    TextUI ui = new TextUI();
    ArrayList<User> login = new ArrayList<>();
    FileIO io = new FileIO();

    User user = new User("","");




    public Menu()
    {
    }

   //print out the username and password
    public void getLogin()
    {
        for (User user : login) {
            String username = user.getUsername();
            String password = user.getPassword();
            System.out.println("Username: " + username + ", Password: " + password);
        }
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

    //Shows the mainMenu and save the users respond.
    public void mainMenu()
    {
        String input = ui.getInput("Please select one of the following: " +
                "\n 1: Search for a specific movie" +
                "\n 2: Choose category" +
                "\n 3: Movies you've seen" +
                        "\n 4: Saved movies");

        int inputInt =Integer.valueOf(input);
        switch (inputInt) {
            case 1:
                movieSearch();
                break;
            case 2:
                chooseCategorie();
                break;
            case 3:
                user.getWatchedMedia();
                break;
            case 4:
                user.getSavedMedia();
                break;
            default:
                ui.displayMessage("Please write a number");
        }
    }

    public void createLogin()
    {
        String inputUsername = ui.getInput("Please write a username: ");
        String inputPassword = ui.getInput("Please write a password: ");
        User user = new User(inputUsername, inputPassword);
        login.add(user);
        io.saveLogin(login);
        mainMenu();

    }

    public void login() {
        String inputUsername = ui.getInput("Please write your username: ");
        String inputPassword = ui.getInput("Please write your password: ");
        if (io.readFile(inputUsername, inputPassword, "data.txt")) {
            ui.displayMessage("Welcome back!");
        }
        mainMenu();
    }

    //Marwa
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
