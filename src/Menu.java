package src;

public class Menu {

    TextUI ui = new TextUI();


    public Menu()
    {

    }

    //Starts the program, where it reads the users answer, login, create account or something went wrong
    public void startMenu() {
        Boolean validInpit = false;
        String password = "";
        String username = "";
        User user = new User(username, password);

        while(!validInpit){
        String input = String.valueOf(ui.getInput("Hello, welcome to CHILL! Do you want to create account or login?"));

            if(input.equalsIgnoreCase("create account")) {
            user.createLogin();
            validInpit = true;
        } else if (input.equalsIgnoreCase("login")) {
            user.login();
            validInpit = true;
        } else {
                ui.displayMessage("Something went wrong, please try again");
            }
        }
    }


    public void mainMenu()
    {
    ui.displayMessage("mainMenu");
    }
}
