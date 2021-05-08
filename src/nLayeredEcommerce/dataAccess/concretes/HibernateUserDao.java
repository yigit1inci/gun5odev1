package nLayeredEcommerce.dataAccess.concretes;

import nLayeredEcommerce.dataAccess.abstracts.UserDao;
import nLayeredEcommerce.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class HibernateUserDao implements UserDao {
    List<User> users = new ArrayList<User>();

    @Override
    public void save(User user) {
        users.add(user);
        System.out.println("Hibernate ile kaydedildi : " + user.getEmail());
    }

    @Override
    public void login(User user) {
        System.out.println("Hibernate ile giriş yapıldı : " + user.getEmail());
    }

    @Override
    public void update(User user) {
        System.out.println("Hibernate ile güncellendi : " + user.getEmail());
    }

    @Override
    public void delete(User user) {
        System.out.println("Hibernate ile silindi : " +user.getEmail());
    }

    @Override
    public User get(int id) {
        for(User user : users){
            if(user.getId()==id){
                System.out.println(user.getEmail() + " " + user.getFirstName() + " " + user.getLastName());
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserEmail(String email) {
        for (User user : users) {
            if (user.getEmail() == email) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return users;
    }
}
