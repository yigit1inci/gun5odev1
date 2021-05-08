package nLayeredEcommerce.core.emailVerification;

public class EmailManager implements EmailService {

    @Override
    public void send(String email) {
        System.out.println(email + " mail adresinize doğrulama maili gönderildi.");
    }

    @Override
    public boolean isVerified(String option) {
        if (option.equals("12345")) {
            System.out.println("Mail adresiniz doğrulandı. Hesabınıza giriş yapabilirsiniz.");
            return true;
        }
        System.out.println("Mail adresiniz doğrulanamadı. Mail adresinizi kontrol edin.");
        return false;
    }
}
