package gr.seemslegit.trashbeastbackend.WebControllers;

import java.util.List;

import gr.seemslegit.trashbeastbackend.Model.Village;
import gr.seemslegit.trashbeastbackend.Service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VillageController {

    @Autowired
    private VillageService villageService;

    @RequestMapping(value = "/getAllVillages")
    public List<Village> getVillages() {
        return villageService.getAllVillages();
    }

    @RequestMapping(value = "/addVillage")
    public ResponseEntity<?> addVillage(@RequestParam(value = "name") String name,
                                        @RequestParam(value = "lat") Double latitude,
                                        @RequestParam(value = "lon") Double longitude) {
        villageService.addVillage(name, latitude, longitude);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/findOptimal")
    public void findOptimal() {
        villageService.findOptimal();
    }
}
