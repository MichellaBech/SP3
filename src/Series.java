package src;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Series {

    FileIO io = new FileIO();
    TextUI ui = new TextUI();

    public void seasonsAndEpisodes()
    {
        ArrayList<String> totalSeasonsAndEpisodes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("100bedsteserier.txt")))
        {
            String line;
            while((line = br.readLine())!=null)
            {
                String lineParts = String.valueOf(line.lastIndexOf(";"));
                int lastIndex = line.lastIndexOf(lineParts);

                if(lastIndex != -1) {
                        String lastPart = line.substring(lastIndex).trim();
                        totalSeasonsAndEpisodes.add(lastPart);

                    ui.displayMessage("Total number of seasons and episodes: " + lastPart);
                    }
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
   /* public String numberOfEpisodes()
    {
        seasonsAndEpisdoes();
        return
    }

    public int numberOfSeasons()
    {
        ;
    }

    */
}
