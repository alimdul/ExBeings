package by.pivovarevich.ex_beings.command;

import by.pivovarevich.ex_beings.controller.Router;
import by.pivovarevich.ex_beings.entity.Alien;
import by.pivovarevich.ex_beings.logic.AlienTypeLogic;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ResourceBundle;

public class ShowAlienTypeCommand implements Command {

    private static final String PARAMETER_ALIEN_TYPE = "alienType";
    private static final String PATH_PROPERTY_CONFIG = "property.config";
    private static final String PATH_GUEST_MAIN_PAGE = "path.page.guestmain";
    private static final String PATH_GUEST_ALIEN_TYPE_PAGE = "path.page.guestalientype";
    private static final String PATH_PROPERTY_MESSAGE = "property.messages";
    private static final String PATH_GUEST_ALIEN_PAGE = "path.page.guestalien";
    private static final String PATH_USER_ALIEN_PAGE = "path.page.useralien";
    private static final String MESSAGE_EMPTY_LIST = "path.page.emptylist";

    private AlienTypeLogic logic;

    public ShowAlienTypeCommand(AlienTypeLogic logic) {
        this.logic = logic;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        String alienTypeName = request.getParameter(PARAMETER_ALIEN_TYPE);

        Router router = new Router();
        ResourceBundle configResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_CONFIG);

        List<Alien> aliens = logic.findAliensInType(alienTypeName);
        if(aliens.isEmpty()) {
            ResourceBundle messageResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_MESSAGE);
            request.setAttribute("emptyList", messageResourceBundle.getString(MESSAGE_EMPTY_LIST));
            router.setRoute(Router.RouteType.FORWARD);                                                   //уточнить!!!
            if("guest".equals(request.getSession().getAttribute("role"))) {
                router.setPagePath(configResourceBundle.getString(PATH_GUEST_ALIEN_TYPE_PAGE));
            } else {
                //router.setPagePath(configResourceBundle.getString(PATH_USER_ALIEN));
            }
        } else {
            router.setRoute(Router.RouteType.FORWARD);
            if("guest".equals(request.getSession().getAttribute("role"))) {
                request.setAttribute("aliens", aliens);
                router.setPagePath(configResourceBundle.getString(PATH_GUEST_ALIEN_TYPE_PAGE));
            } else {
                //router.setPagePath(configResourceBundle.getString(PATH_USER_ALIEN));
            }
        }
        return router;
    }
}
