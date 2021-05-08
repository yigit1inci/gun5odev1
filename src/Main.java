import nLayeredEcommerce.business.abstracts.AuthService;
import nLayeredEcommerce.business.concretes.AuthManager;
import nLayeredEcommerce.core.emailVerification.EmailManager;
import nLayeredEcommerce.business.concretes.UserManager;
import nLayeredEcommerce.core.adapters.GoogleAuthManagerAdapter;
import nLayeredEcommerce.core.emailVerification.EmailService;
import nLayeredEcommerce.dataAccess.concretes.HibernateUserDao;
import nLayeredEcommerce.entities.concretes.User;

public class Main {

    public static void main(String[] args) {

        User user1 = new User(1,"İnci","Yiğit","nc.ygt.34@gmail.com","Abc123***");
        User user2 = new User(2,"Işıl","Yiğit","isilyigit@yandex.com","abc12345*");
        User user3 = new User(3,"Fatma","Yiğit","fatmayigit@hotmail.com","ab12**");
        User user4 = new User(4,"Mehmet","Yiğit","mehmetyigit@msn.com","a1b2c3*");

        UserManager userManager = new UserManager(new HibernateUserDao());
        userManager.save(user1);
        userManager.delete(user2);
        userManager.update(user3);
        userManager.login(user4);
        userManager.get(1);
        userManager.getAll();

        AuthService authService = new AuthManager(new UserManager(new HibernateUserDao()),
                new GoogleAuthManagerAdapter(), new EmailManager());

        String googleAccount = "nc.ygt.34@gmail.com";
        authService.save(googleAccount);
        authService.loginWithGoogle(googleAccount);
        System.out.println("Giriş başarılı");

        authService.save(1,"İnci", "Yiğit","nc.ygt.34@gmail.com","Abc123***");
        authService.login("nc.ygt.34@gmail.com","Abc123***");
        authService.save(2,"Işıl","Yiğit","","abc12345*");
        authService.save(3, "Fatma", "Yiğit", "fatmayigit", "ab12**");
        authService.save(4, "Mehmet", "Yiğit", "mehmetyigit@msn.com", "a1b2c");
        authService.save(5, "A", "B", "ab@ab.com", "A1b2c*");;
        authService.save(1, "İnci", "Yiğit", "nc.ygt.34@gmail.com", "Abc123***");;
        authService.login("inciyigit","Abc123***");
        authService.login("","");





    }
}
