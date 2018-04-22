package by.pivovarevich.ex_beings.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDataValidator {

    private static final String CORRECT_LOGIN = "^[A-Za-z][\\w-\\.]{2,19}$";
    private static final String CORRECT_PASSWORD = "^[\\w\\W]{8,20}$";
    private static final String CORRECT_MAIL = "^[-\\w\\.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";

    public boolean loginValidate(String login) {
        Pattern loginPattern = Pattern.compile(CORRECT_LOGIN);
        Matcher loginMatcher = loginPattern.matcher(login);
        return (loginMatcher.matches());
    }

    public boolean passwordValidate(String password) {
        Pattern passwordPattern = Pattern.compile(CORRECT_PASSWORD);
        Matcher passwordMatcher = passwordPattern.matcher(password);
        return (passwordMatcher.matches());
    }

    public boolean mailValidate(String mail) {
        Pattern mailPattern = Pattern.compile(CORRECT_MAIL);
        Matcher mailMatcher = mailPattern.matcher(mail);
        return (mailMatcher.matches());
    }
}
