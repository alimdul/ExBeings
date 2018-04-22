package by.pivovarevich.ex_beings.command;

import by.pivovarevich.ex_beings.controller.Router;
import by.pivovarevich.ex_beings.logic.UserLogic;
import by.pivovarevich.ex_beings.validator.UserDataValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ResourceBundle;

public class RegisterCommand  implements Command {

    private static final String PARAMETER_LOGIN = "login";
    private static final String PARAMETER_PASSWORD = "password";
    private static final String PARAMETER_MAIL = "mail";
    private static final String PATH_PROPERTY_CONFIG = "property.config";
    private static final String PATH_PROPERTY_MESSAGE = "property.messages";
    private static final String PATH_USER_MAIN_PAGE = "path.page.usermain";
    private static final String PATH_REGISTER_PAGE = "path.page.register";
    private static final String MESSAGE_SYNTAX_ERROR = "message.registersyntaxerror";

    private UserLogic logic;

    public RegisterCommand(UserLogic logic) {
        this.logic = logic;
    }

    @Override
    public Router execute(HttpServletRequest request) {

        String login = request.getParameter(PARAMETER_LOGIN);
        String password = request.getParameter(PARAMETER_PASSWORD);
        String mail = request.getParameter(PARAMETER_MAIL);

        Router router = new Router();
        ResourceBundle configResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_CONFIG);
        HttpSession session = request.getSession(true);
        UserDataValidator validator = new UserDataValidator();

        if(validator.loginValidate(login) && validator.passwordValidate(password) && validator.mailValidate(mail)) {
            if(logic.addUser(login, password, mail)) {
                session.setAttribute("role", "user");
                session.setAttribute("name", login);
                router.setPagePath(configResourceBundle.getString(PATH_USER_MAIN_PAGE));
            } else {
                ResourceBundle messageResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_MESSAGE);
                request.setAttribute("errorSyntax", messageResourceBundle.getString(MESSAGE_SYNTAX_ERROR));
                router.setPagePath(configResourceBundle.getString(PATH_REGISTER_PAGE));
            }
        } else {
            ResourceBundle messageResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_MESSAGE);
            request.setAttribute("errorSyntax", messageResourceBundle.getString(MESSAGE_SYNTAX_ERROR));
            router.setPagePath(configResourceBundle.getString(PATH_REGISTER_PAGE));
        }
        return router;
    }
}
