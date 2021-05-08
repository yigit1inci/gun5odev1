package nLayeredEcommerce.googleAuth;

import nLayeredEcommerce.core.adapters.AuthServiceAdapter;

public class GoogleAuthManager implements AuthServiceAdapter {

    public void save(String email) {
        System.out.println(email + " Google hesabıyla kaydedildi.");
    }

    public void login(String email) {
        System.out.println(email + " Google hesabıyla giriş yapıldı.");
    }

}
