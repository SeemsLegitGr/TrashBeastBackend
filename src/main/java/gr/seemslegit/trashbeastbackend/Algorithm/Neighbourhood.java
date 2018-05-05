package gr.seemslegit.trashbeastbackend.Algorithm;

import java.util.List;

public class Neighbourhood {

    List<Node> nodesNear;

    public Neighbourhood(List<Node> nodesNear) {
        this.nodesNear = nodesNear;
    }

    public List<Node> getNodesNear() {
        return nodesNear;
    }

    public void setNodesNear(List<Node> nodesNear) {
        this.nodesNear = nodesNear;
    }
}

