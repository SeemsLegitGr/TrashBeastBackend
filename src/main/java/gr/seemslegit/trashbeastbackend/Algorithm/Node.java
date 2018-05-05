package gr.seemslegit.trashbeastbackend.Algorithm;

import java.util.List;

public class Node {

    String name;
    List<Node> hood;
    List<Path> paths;

    public Node(String name) {
        this.name = name;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }

    public List<Node> getHood() {
        return hood;
    }

    public void setHood(List<Node> hood) {
        this.hood = hood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
