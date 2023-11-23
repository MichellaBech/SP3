package src;

import java.util.ArrayList;

public class Menu {

    TextUI ui = new TextUI();
    FileIO io = new FileIO();
    ArrayList<User> login = new ArrayList<>();

    User user = new User("", "");


    public Menu() {
        //FileIO io = new FileIO();
        //login = io.readLoginFromFile("data.txt");
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
                "\n 2: Choose category" +
                "\n 3: Movies you've seen" +
                "\n 4: Saved movies" +
                "\n 5: View all movies" +
                "\n 6: View all series");

        int inputInt = Integer.valueOf(input);
        switch (inputInt) {
            case 1:
                movieSearch("100bedstefilm.txt");
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
            case 5:
                viewAllMovies(user);
                break;
            case 6:
                viewAllSeries(user);
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

    public void login(User user) {
        FileIO io = new FileIO();
        String inputUsername = ui.getInput("Please write your username: ");
        String inputPassword = ui.getInput("Please write your password: ");
        if (io.readFile(inputUsername, inputPassword, "data.txt")) {
            ui.displayMessage("Welcome back!");
        }
        mainMenu(user);
    }

    //Method for searching movies in general or getting movielist sorted by publication year
    
    public void movieSearch(FileIO io, String filepath) {

        int userChoice = ui.getIntInput("Choose an option:\n 1. Search movie\n 2. Get movielist by publication year");


        switch (userChoice) {
            case 1:
                String inputSearch = ui.getInput("Search movie");
                ArrayList<String> searchingResults = io.searchMovies(inputSearch, filepath);

                if (searchingResults.size() == 0) {
                    ui.displayMessage("no search results was found");
                } else {
                    ui.displayMessage("Search results:");
                    for (String results : searchingResults) {
                        ui.displayMessage(results);
                    }

                }
                break;

            case 2:

                ArrayList<Movies>publication = io.publication(filepath);

                if (publication.size() == 0) {
                    ui.displayMessage("no search results was found");
                } else {
                    ui.displayMessage("Search results sorted by publication year:");
                    for (Movies movie : publication) {
                        ui.displayMessage("Title:" + movie.getTitle() + ",Publication Year:" + movie.getPublication());
                    }

                }
                break;

            default:
                ui.displayMessage("Invalid choice. Please choose 1 or 2.");

                break;
        }
    }

    String inputSelect = ui.getInput("Select movie");
    String choice = ui.getInput("Will you like to play or save movie");
        if(choice.equals("play")) {
        ui.displayMessage(choice + " is now playing");
    } else if(inputSelect.equals("save"))

    {
        ui.displayMessage(choice + " movie is being saved");
    } else

    {
        ui.displayMessage("Please enter 'play' or 'save'. ");
    }
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
        ui.displayMessage("You choose: " + io.searchInFile("100bedstefilm.txt", movieSave));
        while(!isValid) {
            String choice = ui.getInput("Do you want to save or play the movie?");
            if(choice.equals("save")) {
                user.saveMedia(movieSave, user);
                isValid = true;
            } else if(choice.equals("play")) {
                    ui.displayMessage(choice + " is now playing");
                isValid = true;
            } else {
                ui.displayMessage("Please write save or play");
            } }
    }
}
