package gr.seemslegit.trashbeastbackend.Service;

import java.io.File;
import java.io.FileNotFoundException;
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
    public void parseFile(String filename) {
        String origin, destination, distance, originName,
                originCoords, destinationName, destinationCoords, distanceName, distKMeters;
        double originX, originY, destinationX, destinationY, distanceKMeters;

        try {
            Scanner read, split;
            split = new Scanner(new File(filename));

            split.useDelimiter(";");

            origin = split.next();
            destination = split.next();
            distance = split.next();

            System.out.println(origin);
            System.out.println(destination);
            System.out.println(distance);


            read = new Scanner(origin).useDelimiter(":");
            originName = read.next();
            originName = originName.split("[\"]")[1];
            originCoords = read.next();
            String[] helper = originCoords.split(",");
            originX = Double.parseDouble(helper[0]);
            originY = Double.parseDouble(helper[1]);

            System.out.println(originName);
            System.out.println(originCoords);
            System.out.println(originX + originY);


            read = new Scanner(destination).useDelimiter(":");
            destinationName = read.next();
            destinationName = destinationName.split("[\"]")[1];
            destinationCoords = read.next();
            helper = originCoords.split(",");
            destinationX = Double.parseDouble(helper[0]);
            destinationY = Double.parseDouble(helper[1]);

            System.out.println(destinationName);
            System.out.println(destinationCoords);


            read = new Scanner(distance).useDelimiter(":");
            distanceName = read.next();
            distanceName = distanceName.split("[\"]")[1];
            distKMeters = read.next();
            float dis = Float.parseFloat(distKMeters);

            System.out.println(distanceName);
            System.out.println(distKMeters);


            split.close();

            Village o = villageRepository.findByName(originName);
            Village d = villageRepository.findByName(destinationName);

            Path path = new Path();
            path.setDestination(d);
            path.setOrigin(o);
            path.setDistance(dis);
            pathRepository.save(path);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
