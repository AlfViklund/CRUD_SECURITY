package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import web.model.User;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@EnableTransactionManagement(proxyTargetClass = true)
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) { entityManager.persist(user); }

    @Override
    @Transactional
    public void delete(User user) {
        //entityManager.remove(getUserById(user.getId()));
        entityManager.createQuery("delete User where id = :id").
                setParameter("id", user.getId()).
                executeUpdate();
        }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserByName(String name) {
        try {
            return entityManager.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class).
                    setParameter("name", name).getSingleResult();
        }catch (NoResultException ex) {
        }
        return null;
    }
}
