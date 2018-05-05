package gr.seemslegit.trashbeastbackend.Model;

import javax.persistence.*;

@Entity
public class Path {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Village getOrigin() {
        return origin;
    }

    public void setOrigin(Village origin) {
        this.origin = origin;
    }

    public Village getDestination() {
        return destination;
    }

    public void setDestination(Village destination) {
        this.destination = destination;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    @OneToOne
    private Village origin;

    @OneToOne
    private Village destination;

    private float distance;



}
