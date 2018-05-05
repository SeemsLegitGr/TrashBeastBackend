package gr.seemslegit.trashbeastbackend.Service;

import gr.seemslegit.trashbeastbackend.Model.Village;
import java.util.List;

public interface VillageService {

    List<Village> getAllVillages();
    void addVillage(String name,Double latitude,Double longitude);
    void findOptimal();
}
