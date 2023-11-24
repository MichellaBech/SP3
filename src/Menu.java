package src;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Menu {

    TextUI ui = new TextUI();
    FileIO io = new FileIO();
    ArrayList<User> login = new ArrayList<>();

    User user = new User("", "");


    public Menu() {
    }

    //Search for a specific user
    public User findUser(String username) {
        for (User user : login) {
            if (user.getUsername().contains(username)) {
                return user;
            }
        }
        return null;
    }

    //Starts the program, where it reads the users answer, login, create account or something went wrong
    public void startMenu() {

        io.scanMedia("100bedstefilm.txt");
        io.scanMedia("100bedsteserier.txt");
        Boolean validInput = false;
        String password = "";
        String username = "";
        User user = new User(username, password);

        while (!validInput) {
            String input = String.valueOf(ui.getInput("Hello, welcome to CHILL! Do you want to create account or login?"));

            if (input.equalsIgnoreCase("create account")) {
                createLogin();
                validInput = true;
            } else if (input.equalsIgnoreCase("login")) {
                login(user);
                validInput = true;
            } else {
                ui.displayMessage("Something went wrong, please try again");
            }
        }
        io.readLoginFromFile("data.txt");
    }


    //Shows the mainMenu and save the users respond.
    public void mainMenu(User user) {
        String input = ui.getInput("Please select one of the following: " +
                "\n 1: Search for a specific movie" +
                        "\n 2: Search for a specific series" +
                "\n 3: Choose category" +
                "\n 4: Movies you've seen" +
                "\n 5: Saved movies" +
                "\n 6: View all movies" +
                "\n 7: View all series" +
                "\n 8: Seasons and episodes");

        int inputInt = Integer.valueOf(input);
        switch (inputInt) {
            case 1:
                movieSearch("100bedstefilm.txt", user);
                break;
            case 2:
                seriesSearch("100bedsteserier.txt", user);
                break;
            case 3:
                chooseCategorie();
                break;
            case 4:
                user.getWatchedMedia(user);
                break;
            case 5:
                user.getSavedMedia(user);
                break;
            case 6:
                viewAllMovies(user);
                break;
            case 7:
                viewAllSeries(user);
                break;
            case 8:
                seriesSeasonsAndEpisodes(user);
                break;

            default:
                ui.displayMessage("Please write a number between 1-4");
        }
    }

    public void createLogin() {
        FileIO io = new FileIO();
        String inputUsername = ui.getInput("Please write a username: ");
        String inputPassword = ui.getInput("Please write a password: ");
        User user = new User(inputUsername, inputPassword);
        login.add(user);
        io.saveLogin(login);
        mainMenu(user);

    }

    public void login(User user)
    {
        FileIO io = new FileIO();
        String inputUsername = ui.getInput("Please write your username: ");
        String inputPassword = ui.getInput("Please write your password: ");
        try {
            boolean loggedIn = (io.readFile(inputUsername, inputPassword, "data.txt"));
            if(loggedIn)
            {
                ui.displayMessage("Welcome back!");
                mainMenu(user);
            } else {
                ui.displayMessage("Sorry! Something went wrong, please try again later.");
                //Handle the unsuccessful login
            }
        } catch(RuntimeException e) {
        // Log or handle the exception
        ui.displayMessage("Error occurred: " + e.getMessage());

        }
    }

    //Marwa
    public void movieSearch(String filepath, User user) {
        ArrayList<User> input = new ArrayList<>();
        ui.displayMessage("All movies: " + io.scanMedia("100bedstefilm.txt"));
        FileIO io = new FileIO();
        String inputSearch = ui.getInput("Search movie: ");
        ArrayList<String> searchingResults = io.searchMovies(inputSearch, filepath);

        if (searchingResults.size() == 0) {
            ui.displayMessage("no search results was found");
        } else {
            ui.displayMessage("search results: ");
            for (String results : searchingResults) {
                ui.displayMessage(results);
            }
        }
    String inputSelect = ui.getInput("Select movie: ");
        ui.displayMessage("You choose: " + io.searchInFile("100bedstefilm.txt", inputSelect));
    String choice = ui.getInput("Will you like to play or save movie");
        if(choice.equals("play")) {
        play(choice);
    } else if(inputSelect.equals("save"))
            user.saveMedia(inputSelect, user);
    {
        ui.displayMessage(choice + " movie is being saved");
    }
    }

    public void seriesSearch(String filepath, User user) {
        FileIO io = new FileIO();
        String inputSearch = ui.getInput("Search series");
        ArrayList<String> searchingResults = io.searchMovies(inputSearch, filepath);

        if (searchingResults.size() == 0) {
            ui.displayMessage("no search results was found");
        } else {
            ui.displayMessage("search results: ");
            for (String results : searchingResults) {
                ui.displayMessage(results);
            }
        }
        String inputSelect = ui.getInput("Select series");
        String choice = ui.getInput("Will you like to play or save series");
        if(choice.equals("play")) {
            ui.displayMessage(choice + " is now playing");
        } else if(inputSelect.equals("save"))
            user.saveMedia(inputSelect, user);
        {
            ui.displayMessage(choice + " series is being saved");
        }
    }



public void play(String movieFindInFile)
{
    ArrayList<User> input = new ArrayList<>();
    ui.displayMessage(movieFindInFile + " is now playing");
    //method to save in the list in user class
    io.saveWatchedMedia(input, user);
}

    //Make a method call from FileIO
    public void chooseCategorie()
    {

    }

    public void getRating()
    {

    }

    public void viewAllSeries(User user) {
    Boolean isItValid = false;
                ui.displayMessage("All series: " + io.scanMedia("100bedsteserier.txt"));
    String serieSave = ui.getInput("Write the name of the serie you want to save or play");
               ui.displayMessage("You choose: " +  io.searchInFile("100bedsteserier.txt", serieSave));
                while(!isItValid) {
        String choice = ui.getInput("Do you want to save or play the serie?");
        if(choice.equals("save")) {
            user.saveMedia(serieSave, user);
            isItValid = true;
        } else if(choice.equals("play")) {
            ui.displayMessage(choice + " is now playing");
            isItValid = true;
        } else {
            ui.displayMessage("Please write save or play");
        } }}

    public void viewAllMovies(User user)
    {
        Boolean isValid = false;

        ui.displayMessage("All movies: " + io.scanMedia("100bedstefilm.txt"));
        String movieSave = ui.getInput("Write the name of the movie you want to save or play");
        String movieFindInFile = String.valueOf(io.searchInFile("100bedstefilm.txt", movieSave));
        ui.displayMessage("You choose: " + movieFindInFile);
        while(!isValid) {
            String choice = ui.getInput("Do you want to save or play the movie?");
            if(choice.equals("save")) {
                user.saveMedia(movieSave, user);
                isValid = true;
            } else if(choice.equals("play")) {
                    play(movieFindInFile);
                isValid = true;
            } else {
                ui.displayMessage("Please write save or play");
            } }
    }

    public void seriesSeasonsAndEpisodes(User user)
    {
        Series series = new Series();
        ui.displayMessage("All series: " + io.scanMedia("100bedsteserier.txt"));
        series.seasonsAndEpisodes();
        String input = ui.getInput("Do you want to go back to main menu? Y/N");
        if (input.equalsIgnoreCase("Y") ){
            mainMenu(user);
        } else {
            ui.displayMessage("We hope to see you soon again!");
        }
    }
}
