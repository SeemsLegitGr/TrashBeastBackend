package gr.seemslegit.trashbeastbackend.Service;

import gr.seemslegit.trashbeastbackend.Model.Village;
import gr.seemslegit.trashbeastbackend.Repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VillageServiceImpl implements VillageService {

    @Autowired
    VillageRepository villageRepository;

    @Override
    public List<Village> getAllVillages(){
        return villageRepository.findAll();
    }

    @Override
    public void addVillage(String name, Double latitude, Double longitude){
        Village village = new Village();
        village.setName(name);
        village.setLatitude(latitude);
        village.setLongitude(longitude);
        villageRepository.save(village);


    }
}
