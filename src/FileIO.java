package src;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FileIO {

    ArrayList<User> login = new ArrayList<>();

    public ArrayList<User> readLoginFromFile(String path) {
        ArrayList<User> loginList = new ArrayList<>();
        TextUI ui = new TextUI();

        try {
            File myObj = new File(path);
            if (!myObj.exists()) {
                ui.displayMessage("File not found: " + path);
            }
            try (Scanner myReader = new Scanner(myObj)) {
                String line = myReader.nextLine();
                while (myReader.hasNextLine()) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String username = parts[0];
                        String password = parts[1];
                        User user = new User(username, password);
                        loginList.add(user);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return loginList;
    }


        //This method saves login
    public void saveLogin(ArrayList<User> login) {
        TextUI ui = new TextUI();
        try {
            FileWriter writer = new FileWriter("data.txt", true);
            for (User c : login) {
                String textTosave = c.getUsername() + "," + c.getPassword();
                writer.write(textTosave + "\n");
            }
            writer.close();
        } catch (IOException e) {
            ui.displayMessage("Something went wrong while writing to file ");
        }
    }

    public boolean readFile(String username, String password, String path) {
        Menu menu = new Menu();
        TextUI ui = new TextUI();
        try {
            File myObj = new File(path);
            if (!myObj.exists()) {
                ui.displayMessage("File not found: " + path);
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
        TextUI ui = new TextUI();
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
            ui.displayMessage("File not found");
        }
        return data;
    }

    public ArrayList<String> scanMediaCategories(String path, String userInput)
    {
        ArrayList<String> data = new ArrayList();
        TextUI ui = new TextUI();
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
            ui.displayMessage("File not found");
        }
        return data;
    }

    public ArrayList<String> searchMovies(String searchInput, String path) {
        ArrayList<String> movieList = new ArrayList<>();
        File file = new File(path);

        try{
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                String movies = scan.nextLine();
                if (movies.contains(searchInput)) {
                    movieList.add(movies);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return movieList;
    }


}
