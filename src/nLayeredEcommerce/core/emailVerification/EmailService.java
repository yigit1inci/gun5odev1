package nLayeredEcommerce.core.emailVerification;

public interface EmailService {
    void send(String email);
    boolean isVerified(String option);
}
