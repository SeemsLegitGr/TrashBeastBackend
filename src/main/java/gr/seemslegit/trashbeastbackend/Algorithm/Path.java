package gr.seemslegit.trashbeastbackend.Algorithm;

public class Path {

    Node start;
    Node next;
    long distance;

    public Path() {

    }

    public Path(Node start, Node next, long distance) {
        this.start = start;
        this.next = next;
        this.distance = distance;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }
}
