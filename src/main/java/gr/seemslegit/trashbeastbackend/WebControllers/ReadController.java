package gr.seemslegit.trashbeastbackend.WebControllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import gr.seemslegit.trashbeastbackend.Service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ReadController {

    @Autowired
    ReadService readService;

    @RequestMapping(path = "/readFile")
    public void readFile(@RequestParam(value = "file") MultipartFile file) {

        BufferedReader br;
        List<String> result = new ArrayList<>();
        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        readService.parseFile(result);

        System.out.println(file);

    }
}
