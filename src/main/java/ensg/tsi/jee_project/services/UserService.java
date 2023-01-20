package ensg.tsi.jee_project.services;

import ensg.tsi.jee_project.metier.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
public class UserService {
    private final SessionFactory sessionFactory;


    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String create(User user) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        return user.getLogin();
    }

    public User get(long id) {
        Session session = this.sessionFactory.openSession();
        User user = (User) session.get(User.class, id);
        session.close();
        return user;
    }

    public boolean update(long id, String dream_destination) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        try {
            User user = (User) session.get(User.class, id);
            user.setDream_destination(dream_destination);
            session.update(user);
            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            session.getTransaction().commit();
            session.close();
            return false;
        }
    }

    public List<User> getAll() {
        Session session = this.sessionFactory.openSession();
        List res = session.createQuery("from Participant").list();
        session.close();
        return res;
    }
}