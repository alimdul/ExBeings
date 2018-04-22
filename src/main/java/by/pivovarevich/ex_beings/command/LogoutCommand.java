package by.pivovarevich.ex_beings.command;

import by.pivovarevich.ex_beings.controller.Router;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public class LogoutCommand implements Command {

    private static final String PATH_PROPERTY_CONFIG = "property.config";
    private static final String PATH_START_PAGE = "path.page.start";

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        ResourceBundle configResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_CONFIG);

        request.getSession().invalidate();

        router.setRoute(Router.RouteType.REDIRECT);
        router.setPagePath(configResourceBundle.getString(PATH_START_PAGE));
        return router;
    }
}
