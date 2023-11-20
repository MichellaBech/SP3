package src;

import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {

    final Scanner scan = new Scanner(System.in);

    //shows a message and returns the user's input as a String
    public String getInput(String msg){
        this.displayMessage(msg);
        return scan.nextLine();
    }

    public void displayMessage(String msg){

        System.out.println(msg);

    }

    /*
    public String getChoice(ArrayList<String> options, String msg){
        System.out.println(msg);
        //  diplayMenu(options);
        String input = getInput("");

        //tjek om input findes i listen, hvis ikke, smid en exception
        if(!options.contains(input)){
            System.out.println("findes ikke på listen");
            input = getChoice(options, msg);
        }

        return input;
    } */
}
