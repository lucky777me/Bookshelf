package lv.itlat.bookshelf.persistence.repository;

import lv.itlat.bookshelf.persistence.domain.User;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class UserRepository {

    @PersistenceContext(unitName = "bookshelfPU")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Transactional
    public User create(User user) {
        getEntityManager().persist(user);
        return user;
    }

    public List<User> retrieve() {
        return getEntityManager().createQuery("SELECT u FROM User u ", User.class).getResultList();
    }

    public Optional<User> findByLoginName(String loginName) {
        return getEntityManager().createQuery("SELECT u FROM User u WHERE u.loginName = :loginName", User.class)
                .setParameter("loginName", loginName)
                .getResultStream()
                .findFirst();
    }


}
