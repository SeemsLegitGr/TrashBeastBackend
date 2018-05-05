package gr.seemslegit.trashbeastbackend.Service;

import com.mapbox.services.api.directions.v5.DirectionsCriteria;
import com.mapbox.services.api.directions.v5.MapboxDirections;
import com.mapbox.services.commons.models.Position;
import gr.seemslegit.trashbeastbackend.Model.Village;
import gr.seemslegit.trashbeastbackend.Repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PathServiceImpl implements PathsService {

    @Autowired
    VillageRepository villageRepository;

    @Override
    public void calculateDistances(){
        List<Village> villageList= villageRepository.findAll();

        MapboxDirections client = new MapboxDirections.Builder()
                .setAccessToken("pk.eyJ1Ijoia3Jpc2ltZW4iLCJhIjoiY2o4c2xlNmEzMDk2azMycjBqM3J0ZXdsMCJ9.O6RwR4phSWHd1cznwDGixg")
                                .setOrigin(Position.fromCoordinates(-122.416667, 37.783333))
                                .setDestination(Position.fromCoordinates(-121.9, 37.333333))
                                .setProfile(DirectionsCriteria.PROFILE_DRIVING)
                                .build();
    }
}
