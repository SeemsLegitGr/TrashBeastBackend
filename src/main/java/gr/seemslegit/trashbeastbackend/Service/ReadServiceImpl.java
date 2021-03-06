package gr.seemslegit.trashbeastbackend.Service;

import java.util.List;
import java.util.Scanner;

import gr.seemslegit.trashbeastbackend.Model.Path;
import gr.seemslegit.trashbeastbackend.Model.Village;
import gr.seemslegit.trashbeastbackend.Repository.PathRepository;
import gr.seemslegit.trashbeastbackend.Repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadServiceImpl implements ReadService {

    @Autowired
    PathRepository pathRepository;

    @Autowired
    VillageRepository villageRepository;

    @Override
    public void addPath(String name, Double latitude, Double longitude) {

    }

    @Override
    public void parseFile(List<String> filename) {
        String origin, destination, distance, originName,
                originCoords, destinationName, destinationCoords, distanceName, distKMeters;
        double originLat, originLon, destinationLat, destinationLon, distanceKMeters;

        String currentLine;
        for (String s : filename) {

            Scanner read, split;

            split = new Scanner(s);

            split.useDelimiter(";");

            origin = split.next();
            destination = split.next();
            distance = split.next();

            read = new Scanner(origin).useDelimiter(":");
            originName = read.next();
            originName = originName.split("[\"]")[1];
            originCoords = read.next();
            String[] helper = originCoords.split(",");
            originLat = Double.parseDouble(helper[0]);
            originLon = Double.parseDouble(helper[1]);

            read = new Scanner(destination).useDelimiter(":");
            destinationName = read.next();
            destinationName = destinationName.split("[\"]")[1];
            destinationCoords = read.next();
            helper = originCoords.split(",");
            destinationLat = Double.parseDouble(helper[0]);
            destinationLon = Double.parseDouble(helper[1]);

            read = new Scanner(distance).useDelimiter(":");
            distanceName = read.next();
            distanceName = distanceName.split("[\"]")[1];
            distKMeters = read.next();
            float dis = Float.parseFloat(distKMeters);

            split.close();

            Village o = villageRepository.findByName(originName);
            Village d = villageRepository.findByName(destinationName);

            Path path = new Path();
            path.setDestination(d);
            path.setOrigin(o);
            path.setDistance(dis);
            pathRepository.save(path);
            Path path2 = new Path();
            path2.setDestination(o);
            path2.setOrigin(d);
            path2.setDistance(dis);
            pathRepository.save(path2);
        }
    }
}
