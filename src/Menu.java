package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Menu {

    TextUI ui = new TextUI();
    ArrayList<User> login = new ArrayList<>();

    User user = new User("","");




    public Menu()
    {
        FileIO io = new FileIO();
        login = io.readLoginFromFile("data.txt");
    }

    //Search for a specific user
    public User findUser (String username) {
    for (User user : login) {
        if (user.getUsername().contains(username)) {
            return user;
        }
    }
    return null;
    }

    //Starts the program, where it reads the users answer, login, create account or something went wrong
    public void startMenu() {
        Boolean validInput = false;
        String password = "";
        String username = "";
        User user = new User(username, password);

        while(!validInput){
        String input = String.valueOf(ui.getInput("Hello, welcome to CHILL! Do you want to create account or login?"));

            if(input.equalsIgnoreCase("create account")) {
            createLogin();
            validInput = true;
        } else if (input.equalsIgnoreCase("login")) {
            login(user);
            validInput = true;
        } else {
                ui.displayMessage("Something went wrong, please try again");
            }
        }
    }

    public void setup() {
        FileIO io = new FileIO();
        io.scanMedia("100bedstefilm.txt");
        io.scanMedia("100bedsteserier.txt");
        io.readLoginFromFile("data.txt");
    }

    //Shows the mainMenu and save the users respond.
    public void mainMenu(User user)
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
                user.getSavedMedia(user);
                break;
            default:
                ui.displayMessage("Please write a number between 1-4");
        }
    }

    public void createLogin()
    {
        FileIO io = new FileIO();
        String inputUsername = ui.getInput("Please write a username: ");
        String inputPassword = ui.getInput("Please write a password: ");
        User user = new User(inputUsername, inputPassword);
        login.add(user);
        io.saveLogin(login);
        mainMenu(user);

    }

    public void login(User user) {
        FileIO io = new FileIO();
        String inputUsername = ui.getInput("Please write your username: ");
        String inputPassword = ui.getInput("Please write your password: ");
        if (io.readFile(inputUsername, inputPassword, "data.txt")) {
            ui.displayMessage("Welcome back!");
        }
        mainMenu(user);
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

    public void saveMedia(LinkedList<Media> saveMedia) {
        FileIO io = new FileIO();
       String input = ui.getInput("Write the name of the media you want to save: ");
       io.scanMediaCategories("100bedstefilm.txt", input);
       io.scanMediaCategories("100bedsteserier.txt", input);

    }


    public void selectMedia()
    {

    }


    public void getRating()
    {

    }
}
