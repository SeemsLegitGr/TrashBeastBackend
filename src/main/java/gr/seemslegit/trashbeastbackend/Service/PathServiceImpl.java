package gr.seemslegit.trashbeastbackend.Service;

import com.mapbox.services.api.directions.v5.DirectionsCriteria;
import com.mapbox.services.api.directions.v5.MapboxDirections;
import com.mapbox.services.commons.models.Position;
import gr.seemslegit.trashbeastbackend.Model.Path;
import gr.seemslegit.trashbeastbackend.Repository.PathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PathServiceImpl implements PathsService {

    @Autowired
    PathRepository pathRepository;

    @Override
    public void calculateDistances(){
        List<Path> paths= pathRepository.findAll();

        for (Path path :
                paths) {
            MapboxDirections client = new MapboxDirections.Builder()
                    .setAccessToken("pk.eyJ1Ijoia3Jpc2ltZW4iLCJhIjoiY2o4c2xlNmEzMDk2azMycjBqM3J0ZXdsMCJ9.O6RwR4phSWHd1cznwDGixg")
                    .setOrigin(Position.fromCoordinates(path.getOrigin().getLongitude(), path.getOrigin().getLatitude()))
                    .setDestination(Position.fromCoordinates(path.getDestination().getLongitude(), path.getDestination().getLatitude()))
                    .setProfile(DirectionsCriteria.PROFILE_DRIVING)
                    .build();


        }

    }
}
