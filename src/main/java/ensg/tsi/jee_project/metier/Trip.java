package ensg.tsi.jee_project.metier;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Evenement")
public class Trip {
    @Id
    @GeneratedValue(generator = "incerement")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "tripNb")
    private long tripNb;
    @Column(name = "cityA", nullable = false)
    private String cityA;
    @Column(name = "cityB", nullable = false)
    private String cityB;
    @Column(name = "time", nullable = false)
    private String time;


    @OneToMany(cascade = CascadeType.ALL,mappedBy="event")
    private Set<User> users;

    public Set<User> getParticipants() {
        return users;
    }

    public void setParticipants(Set<User> participants) {
        this.users = participants;
    }

    public Trip() {
    }


    public Trip(long tripNb, String cityA, String cityB, String time) {
        this.tripNb = tripNb;
        this.cityA = cityA;
        this.cityB = cityB;
        this.time = time;
        this.users = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripNb=" + tripNb +
                ", cityA='" + cityA + '\'' +
                ", cityB='" + cityB + '\'' +
                ", time='" + time + '\'' +
                 '}';
    }

    public long getTripNb() {
        return tripNb;
    }

    public void setTripNb(long tripNb) {
        this.tripNb = tripNb;
    }

    public String getCityA() {
        return cityA;
    }

    public void setCityA(String cityA) {
        this.cityA = cityA;
    }

    public String getCityB() {
        return cityB;
    }

    public void setCityB(String cityB) {
        this.cityB = cityB;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
