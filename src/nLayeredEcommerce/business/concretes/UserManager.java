package nLayeredEcommerce.business.concretes;

import nLayeredEcommerce.business.abstracts.UserService;
import nLayeredEcommerce.dataAccess.abstracts.UserDao;
import nLayeredEcommerce.entities.concretes.User;

import java.util.List;

public class UserManager implements UserService {
    private UserDao userDao;

    public UserManager(UserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void login(User user) {
        userDao.login(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public User getUserEmail(String email) {
        return userDao.getUserEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
