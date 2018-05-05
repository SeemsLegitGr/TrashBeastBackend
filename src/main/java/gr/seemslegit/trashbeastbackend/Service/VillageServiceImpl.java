package gr.seemslegit.trashbeastbackend.Service;

import gr.seemslegit.trashbeastbackend.Model.Path;
import gr.seemslegit.trashbeastbackend.Model.Village;
import gr.seemslegit.trashbeastbackend.Repository.PathRepository;
import gr.seemslegit.trashbeastbackend.Repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class VillageServiceImpl implements VillageService {

    @Autowired
    VillageRepository villageRepository;

    @Autowired
    PathRepository pathRepository;

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
    //REMOVE FROM HERE TILL THE END (of time)
    @Override
    public void findOptimal(){
        System.out.println();
        List<Village> villages;
        List<Path> paths = pathRepository.findAll();
        villages = villageRepository.findAll();
        float overallDistance = 0;
        float dist = 99;
        List<Village> route;

        Village currentVillage = villageRepository.getOne(1L);
        List<Path> availablePaths = pathRepository.findByOrigin(currentVillage);


        for (Path path :
                availablePaths) {
            System.out.println(path.getOrigin().getName() + " > " + path.getDestination().getName() + " dist: " + path.getDistance());

            if(path.getDistance() < dist)
            {
                dist = path.getDistance();
                currentVillage = path.getDestination();
            }
            overallDistance+= dist;
        }
        System.out.println(currentVillage.getName() + " with distance: " + dist);


            /*if(availablePaths.get(i).getDistance() < availablePaths.get(i+1).getDistance()){
                dist = availablePaths.get(i).getDistance();
                currentVillage = availablePaths.get(i).getDestination();
                System.out.println(currentVillage.getName() + " " + dist);
            }*/





       /* for (Path path :
                paths) {
            for (Village village: villages){

            }
            System.out.println(path.getOrigin().getName()+ " > " + path.getDestination().getName() + "  Dist: " + path.getDistance());
        }*/
        
        //System.out.println(villages.get(1).getName());
        

    }
}
