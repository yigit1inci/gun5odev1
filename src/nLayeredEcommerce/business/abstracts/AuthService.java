package nLayeredEcommerce.business.abstracts;

public interface AuthService {
    void save(int id,String firstName,String lastName,String email,String password);
    void login(String email, String password);
    void loginWithGoogle(String email);
    void save(String email);
}
