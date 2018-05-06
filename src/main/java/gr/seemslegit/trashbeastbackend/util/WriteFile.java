package gr.seemslegit.trashbeastbackend.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import gr.seemslegit.trashbeastbackend.Service.VillageService;

public class WriteFile {

    private static final String FILENAME = "src\\main\\resources\\testFile.txt";

    public static void main(String[] args) {


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

            String content = "This is the content to write into file\n";

            bw.write(content);

            // no need to close it.
            //bw.close();

            System.out.println("Done");
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
