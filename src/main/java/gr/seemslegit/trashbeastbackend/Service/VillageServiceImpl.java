package gr.seemslegit.trashbeastbackend.Service;

import java.util.List;
import java.util.Random;

import gr.seemslegit.trashbeastbackend.Model.Path;
import gr.seemslegit.trashbeastbackend.Model.Village;
import gr.seemslegit.trashbeastbackend.Repository.PathRepository;
import gr.seemslegit.trashbeastbackend.Repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VillageServiceImpl implements VillageService {

    @Autowired
    VillageRepository villageRepository;

    @Autowired
    PathRepository pathRepository;

    @Override
    public List<Village> getAllVillages() {
        return villageRepository.findAll();
    }

    @Override
    public void addVillage(String name, Double latitude, Double longitude) {
        Village village = new Village();
        village.setName(name);
        village.setLatitude(latitude);
        village.setLongitude(longitude);
        villageRepository.save(village);
    }

    //REMOVE FROM HERE TILL THE END (of time)
    @Override
    public void findOptimal() {
        System.out.println();
        List<Village> villages;
        List<Path> paths = pathRepository.findAll();
        villages = villageRepository.findAll();
        float totalDistance = 0;
        float dist = 99;
        List<Village> route;
        Random random = new Random();
        boolean notFinished = true;

        Village currentVillage = villageRepository.getOne(1L);
        List<Path> availablePaths = pathRepository.findByOrigin(currentVillage);

        int counter = 0;
        while (notFinished) {
            /*for (Path path : availablePaths) {
                float distance = path.getDistance();
                System.out.println(path.getOrigin().getName() + " > " + path.getDestination().getName() + " distance: " + distance);

                currentVillage.setVisited(true);
                currentVillage = path.getDestination();
                totalDistance += dist;
            }*/

            currentVillage.setVisited(true);
            currentVillage = availablePaths.get(random.nextInt(availablePaths.size())).getDestination();

            for (Village village : villages) {
                if (counter != 0) {
                    counter = 0;
                }
                if (village.isVisited()) {
                    counter++;
                }
            }
            if(counter==10) {
                notFinished = false;
            }
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
