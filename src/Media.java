package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Media
{
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

    public float Rating()
    {
        float count = 0.0F;
        ArrayList<Media> rating = new ArrayList<>();
        return 0.0F;
    }

}
