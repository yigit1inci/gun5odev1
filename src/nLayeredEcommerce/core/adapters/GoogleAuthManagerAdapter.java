package nLayeredEcommerce.core.adapters;

import nLayeredEcommerce.googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthServiceAdapter {

    GoogleAuthManager googleAuthManager = new GoogleAuthManager();

    @Override
    public void save(String email) {
        googleAuthManager.save(email);
    }

    @Override
    public void login(String email) {
        googleAuthManager.login(email);
    }
}
