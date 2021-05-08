package nLayeredEcommerce.business.concretes;

import nLayeredEcommerce.business.abstracts.AuthService;
import nLayeredEcommerce.core.emailVerification.EmailService;
import nLayeredEcommerce.business.abstracts.UserService;
import nLayeredEcommerce.core.adapters.AuthServiceAdapter;
import nLayeredEcommerce.entities.concretes.User;

import java.util.Scanner;
import java.util.regex.Pattern;

public class AuthManager implements AuthService {

    private UserService userService;
    private AuthServiceAdapter authServiceAdapter;
    private EmailService emailService;

    public AuthManager(UserService userService, AuthServiceAdapter authServiceAdapter, EmailService emailService) {
        this.userService = userService;
        this.authServiceAdapter = authServiceAdapter;
        this.emailService = emailService;
    }

    @Override
    public void save(int id, String firstName, String lastName, String email, String password) {
        User user = new User();
        if (!fillAllInformation(user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getPassword())) {
            return;
        }
        if (!nameLengthValid(user.getFirstName(), user.getLastName())) {
            return;
        } else if (!checkEmailFormat(user.getEmail())) {
            return;
        } else if (!exsistEmail(user.getEmail())) {
            return;
        } else if (!passwordLengthValid(user.getPassword())) {
            return;
        } else {
            this.emailService.send(user.getEmail());

            Scanner scanner = new Scanner(System.in);
            System.out.println(user.getEmail() + " Doğrulama Kodu:'12345'. Hesabınızı aktifleştirebilirsiniz.");
            String option = scanner.nextLine();

            if (this.emailService.isVerified(option)) {
                this.userService.save(user);
            } else {
                System.out.println(user.getEmail() + "Kaydedilemedi. Doğrulama başarısız");
            }
        }
    }

    private boolean exsistEmail(String email) {
        if (userService.getUserEmail(email) == null) {
            return true;
        } else {
            System.out.println("Bu mail adresi kayıtlıdır. Mail adresinizle giriş yapabilirsiniz.");
            return false;
        }
    }

    private boolean checkEmailFormat(String email) {
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
        Pattern pattern = Pattern.compile(regex);

        if (pattern.matcher(email).matches()) {
            System.out.println(email);
            return true;
        } else {
            System.out.println("Mail adresi geçersizdir. " +
                    "Mail adresi example@example.com/example@example.com.tr şeklinde olmalı.");
            return false;
        }
    }

    private boolean nameLengthValid(String firstName, String lastName) {
        if (firstName.length() >= 2 && lastName.length() >= 2) {
            return true;
        }
        System.out.println("Adınız ve soyadınız en az 2 karakterden oluşmalıdır.");
        return false;

    }

    private boolean fillAllInformation(String firstName, String lastName, String email, String password) {
        if (firstName.length() > 0 && lastName.length() > 0 && email.length() > 0 && password.length() > 0) {
            return true;
        } else {
            System.out.println("Ad, soyad, email ve şifre alanları boş bırakılamaz.");
            return false;
        }
    }

    private boolean passwordLengthValid(String password) {
        if (password.length() >= 6) {
            return true;
        } else {
            System.out.println("Şifreniz en az 6 karakterden oluşmalıdır.");
            return false;
        }
    }

    @Override
    public void login(String email, String password) {
        User user = userService.getUserEmail(email);
        if (user == null) {
            System.out.println("Geçersiz kullanıcı.");
        } else if (email.length() <= 0 || password.length() <= 0) {
            System.out.println("Email ve şifre alanları boş bırakılamaz.");
        } else if (user.getEmail() != email) {
            System.out.println(user.getEmail() + " hatalı email.");
        } else if (user.getPassword() != password) {
            System.out.println(user.getEmail() + " hatalı şifre.");
        } else {
            System.out.println(user.getEmail() + " giriş yapıldı. " );
        }
    }

    @Override
    public void loginWithGoogle(String email) {
        authServiceAdapter.login(email);
    }

    @Override
    public void save(String email) {
        authServiceAdapter.save(email);
    }
}
