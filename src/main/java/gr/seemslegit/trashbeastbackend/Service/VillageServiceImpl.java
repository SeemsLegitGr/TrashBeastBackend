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

    @Override
    public List<Village> findOptimal() {
        List<Village> villages;
        villages = villageRepository.findAll();
        Village currentVillage = villageRepository.getOne(1L);
        List<Village> optimalRoute = new ArrayList<>();
        optimalRoute.add(currentVillage);

        boolean flag = true;

        while(flag){
            int step =1;
            int counter = 0;
            float overallDistance = 0;
            float dist = 0;
            List<Village> route;
            List<Path> availablePaths = pathRepository.findByOrigin(currentVillage);
            List<Village> visited = villageRepository.findAllByVisited(true);
            System.out.println();
            System.out.println();
            while (visited.size() != 10) {
                Random rand = new Random();

                int r = rand.nextInt(availablePaths.size()) + 0;
                for (Path path :
                        availablePaths) {
                    if (path.getDestination().isVisited()) counter++;
                }
                if (counter >= availablePaths.size()) {
                    currentVillage = availablePaths.get(r).getDestination();
                    dist = availablePaths.get(r).getDistance();
                }
                else {
                    for (Path path :
                            availablePaths) {
                        if (!path.getDestination().isVisited()) {
                            if (path.getDistance() > dist) {
                                dist = path.getDistance();
                                currentVillage = path.getDestination();
                            }
                        }
                    }
                }
                counter = 0;

                overallDistance += dist;
                dist = 0;
                currentVillage.setVisited(true);
                System.out.println(step + ": "+currentVillage.getName() + " with distance: " + overallDistance);

                optimalRoute.add(currentVillage);

                villageRepository.saveAndFlush(currentVillage);
                visited.clear();
                visited = villageRepository.findAllByVisited(true);
                availablePaths.clear();
                availablePaths = pathRepository.findByOrigin(currentVillage);
                step++;
            }
            for (Village v :
                    villages) {
                v.setVisited(false);
                villageRepository.saveAndFlush(v);
            }
            if(currentVillage == villageRepository.getOne(8L)){
                flag = false;
            }


        }


        return optimalRoute;
    }



}

