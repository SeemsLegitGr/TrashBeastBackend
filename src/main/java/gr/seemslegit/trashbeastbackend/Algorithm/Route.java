package gr.seemslegit.trashbeastbackend.Algorithm;

import java.util.List;

public class Route {

    List<Node> nodesPassed;
    List<Node> nodesNotPassed;

    public Route(List<Node> nodesPassed, List<Node> nodesNotPassed) {
        this.nodesPassed = nodesPassed;
        this.nodesNotPassed = nodesNotPassed;
    }

    public List<Node> getNodesPassed() {
        return nodesPassed;
    }

    public void setNodesPassed(List<Node> nodesPassed) {
        this.nodesPassed = nodesPassed;
    }

    public List<Node> getNodesNotPassed() {
        return nodesNotPassed;
    }

    public void setNodesNotPassed(List<Node> nodesNotPassed) {
        this.nodesNotPassed = nodesNotPassed;
    }
}
