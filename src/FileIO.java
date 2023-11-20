package src;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FileIO {

    Menu menu = new Menu();
    TextUI ui = new TextUI();

    //This method saves login
    public void saveLogin(ArrayList<User> login){
        try
        {
            FileWriter writer = new FileWriter("data.txt", true);
            for (User c : login) {
                String textTosave = c.getUsername() + "," + c.getPassword();
                writer.write(textTosave + "\n");
            }
            writer.close();
        } catch(IOException e)
        {
            System.out.println("Something went wrong while writing to file ");
        }

        menu.mainMenu();
    }

    public boolean readFile(String username, String password, String path) {
        try {
            File myObj = new File(path);
            if (!myObj.exists()) {
                System.out.println("File not found: " + path);
                return false;
            }
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String searchString = username + "," + password;
                    if (data.contains(searchString)) {
                        return true;
                    }
                }
                myReader.close();
            }
            } catch (FileNotFoundException ex) {
                System.out.println("Something went wrong reading the file");
            }
            ui.displayMessage("Could not find login, please create account");
             User user = new User(username, password);
            menu.createLogin();
            return false;
        }

    public ArrayList<String> scanMedia(String path)
    {
        ArrayList<String> data = new ArrayList();
        File file = new File(path);
        try
        {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) {
                String s = scan.nextLine();
                data.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return data;
    }

    public ArrayList<String> scanMediaCategories(String path, String userInput)
    {
        ArrayList<String> data = new ArrayList();
        File file = new File(path);
        try
        {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) {
                String s = scan.nextLine();
                if(s.contains(userInput))
                    data.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return data;
    }


}
