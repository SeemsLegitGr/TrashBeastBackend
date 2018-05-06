package gr.seemslegit.trashbeastbackend.Service;

import java.util.List;

public interface ReadService {

    void addPath(String name,Double latitude,Double longitude);
    void parseFile(List<String> filename);
}
