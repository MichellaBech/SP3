package src;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {




    public static void main(String[] args) {
        Menu menu = new Menu();
        ArrayList<User> users = new ArrayList<>();
        //menu.startMenu();

        TextUI ui = new TextUI();
        Boolean validInput = false;
        String password = "";
        String username = "";
        User user = new User(username, password);

        while(!validInput){
            String input = String.valueOf(ui.getInput("Hello, welcome to CHILL! Do you want to create account or login?"));

            if(input.equalsIgnoreCase("create account")) {
                menu.createLogin();
                validInput = true;
            } else if (input.equalsIgnoreCase("login")) {
                menu.login(user);
                validInput = true;
            } else {
                ui.displayMessage("Something went wrong, please try again");
            }
        }


    }









        //FileIO io = new FileIO();
        //System.out.println(io.scanMediaCategories("100bedstefilm.txt", "Drama"));




}
