package ensg.tsi.jee_project.metier;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
@Entity
@Table(name="Participant")
public class User {
    @Id
    @GeneratedValue(generator = "incerement")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "login")
    private String login;
    @Column(name = "prenom", nullable = false)
    private String prenom;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "dream_destination", nullable = false)
    private String dream_destination;
    @Column(name = "admin", nullable = false)
    private boolean admin;

    @ManyToOne(fetch = FetchType.LAZY)
    private Trip trip;

    public User(String login, String prenom, String email, String dream_destination, boolean admin) {
        this.login = login;
        this.prenom = prenom;
        this.email = email;
        this.dream_destination = dream_destination;
        this.admin = admin;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "login=" + login +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", dream_destination='" + dream_destination + '\'' +
                ", admin='" + admin + '\'' +
                '}';
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDream_destination() {
        return dream_destination;
    }

    public void setDream_destination(String dream_destination) {
        this.dream_destination = dream_destination;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
