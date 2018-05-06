package gr.seemslegit.trashbeastbackend.WebControllers;

import gr.seemslegit.trashbeastbackend.Service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadController {

    @Autowired
    ReadService readService;

    String FILENAME = "src\\main\\resources\\testFile.txt";

    @RequestMapping(value ="/read")
    public void findOptimal(){

        readService.parseFile(FILENAME);

    }
}
