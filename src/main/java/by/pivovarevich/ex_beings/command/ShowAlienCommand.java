package by.pivovarevich.ex_beings.command;

import by.pivovarevich.ex_beings.controller.Router;
import by.pivovarevich.ex_beings.entity.Alien;
import by.pivovarevich.ex_beings.logic.AlienLogic;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public class ShowAlienCommand implements Command {

    private static final String PARAMETER_ALIEN = "alien";
    private static final String PATH_PROPERTY_CONFIG = "property.config";
    private static final String PATH_PROPERTY_MESSAGE = "property.messages";
    private static final String PATH_USER_ALIEN_PAGE = "path.page.useralien";
    private static final String MESSAGE_EMPTY_LIST = "path.page.emptylist";

    private AlienLogic logic;

    public ShowAlienCommand(AlienLogic logic) {
        this.logic = logic;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        String alienName = request.getParameter(PARAMETER_ALIEN);

        Router router = new Router();
        ResourceBundle configResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_CONFIG);

        Alien alien = logic.findAlienByName(alienName);
        if(alien == null) {
            ResourceBundle messageResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_MESSAGE);
            request.setAttribute("emptyList", messageResourceBundle.getString(MESSAGE_EMPTY_LIST));
        } else {
            request.setAttribute("alien", alien);
        }
        if(!"guest".equals(request.getSession().getAttribute("role"))) {
            router.setPagePath(configResourceBundle.getString(PATH_USER_ALIEN_PAGE));
        }
        router.setRoute(Router.RouteType.FORWARD);                                                   //уточнить!!!
        return router;
    }
}
