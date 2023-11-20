package src;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FileIO {
    public ArrayList<String> readLoginData(String path) {
        ArrayList<String> data = new ArrayList<>();
        //instantier File
        File file = new File(path);

        try {
            Scanner scan = new Scanner(file);
            scan.nextLine(); //Skip header
            while (scan.hasNextLine()) {
                String s = scan.nextLine();// Hele linjen vil stå i én string   ==>  "Egon, 200"
                data.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        return data;
    }

    public void saveLogin(ArrayList<User> login){
        try

        {
            FileWriter writer = new FileWriter("data.txt");
            writer.write("username,password" + "\n");
            for (User c : login) {
                String textTosave = c.getUsername() + "," + c.getPassword();
                writer.write(textTosave + "\n");
            }
            writer.close();
        } catch(IOException e)
        {
            System.out.println("noget gik galt ved skrivning til fil");
        }

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
            return false;
        }


}
