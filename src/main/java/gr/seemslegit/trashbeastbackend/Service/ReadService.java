package gr.seemslegit.trashbeastbackend.Service;

public interface ReadService {

    void addPath(String name,Double latitude,Double longitude);
    void parseFile(String filename);
}
