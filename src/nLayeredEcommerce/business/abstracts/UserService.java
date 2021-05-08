package nLayeredEcommerce.business.abstracts;

import nLayeredEcommerce.entities.concretes.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void login(User user);
    void update(User user);
    void delete(User user);
    User get(int id);
    User getUserEmail(String email);
    List<User> getAll();
}
