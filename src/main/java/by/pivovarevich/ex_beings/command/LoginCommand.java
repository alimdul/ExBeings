package by.pivovarevich.ex_beings.command;

import by.pivovarevich.ex_beings.controller.Router;
import by.pivovarevich.ex_beings.entity.User;
import by.pivovarevich.ex_beings.logic.UserLogic;
import by.pivovarevich.ex_beings.validator.UserDataValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ResourceBundle;

public class LoginCommand implements Command {

    private static final String PARAMETER_LOGIN = "login";
    private static final String PARAMETER_PASSWORD = "password";
    private static final String PATH_PROPERTY_CONFIG = "property.config";
    private static final String PATH_PROPERTY_MESSAGE = "property.messages";
    private static final String PATH_USER_MAIN_PAGE = "path.page.usermain";
    private static final String PATH_ADMIN_MAIN_PAGE = "path.page.adminmain";
    private static final String PATH_LOGIN_PAGE = "path.page.login";
    private static final String MESSAGE_ERROR = "message.loginerror";
    private static final String MESSAGE_SYNTAX_ERROR = "message.loginsyntaxerror";

    private UserLogic logic;

    public LoginCommand(UserLogic logic) {
        this.logic = logic;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        //String page = null;
        String login = request.getParameter(PARAMETER_LOGIN);
        String password = request.getParameter(PARAMETER_PASSWORD);

        User user;
        Router router = new Router();
        ResourceBundle configResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_CONFIG);
        UserDataValidator validator = new UserDataValidator();
        HttpSession session = request.getSession(true);

        if(validator.loginValidate(login) && validator.passwordValidate(password)) {
            user = logic.authentication(login, password);
            if(user != null) {
                switch (logic.authorization(user)) {
                    case "admin":
                        session.setAttribute("role", "admin");
                        router.setPagePath(configResourceBundle.getString(PATH_ADMIN_MAIN_PAGE));
                        break;
                    case "user":
                        session.setAttribute("role", "user");
                        router.setPagePath(configResourceBundle.getString(PATH_USER_MAIN_PAGE));
                        break;
                }
                session.setAttribute("name", user.getLogin());
            } else {
                ResourceBundle messageResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_MESSAGE);
                request.setAttribute("errorLogin", messageResourceBundle.getString(MESSAGE_ERROR));
                router.setPagePath(configResourceBundle.getString(PATH_LOGIN_PAGE));
                //page = resourceBundle.getString(PATH_LOGIN_PAGE);
            }
        } else {
            ResourceBundle messageResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_MESSAGE);
            request.setAttribute("errorSyntax", messageResourceBundle.getString(MESSAGE_SYNTAX_ERROR));
            router.setPagePath(configResourceBundle.getString(PATH_LOGIN_PAGE));
        }
        return router;
        //return page;
    }
}
