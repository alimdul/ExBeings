package by.pivovarevich.ex_beings.command;

import by.pivovarevich.ex_beings.controller.Router;
import by.pivovarevich.ex_beings.entity.AlienType;
import by.pivovarevich.ex_beings.logic.AlienTypeLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ResourceBundle;

public class ShowAlienTypesListCommand implements Command {

    private static final String PATH_PROPERTY_CONFIG = "property.config";
    private static final String PATH_GUEST_MAIN_PAGE = "path.page.guestmain";
    private static final String PATH_USER_ALIEN_TYPES_LIST_PAGE = "path.page.useralientypelist";
    private static final String PATH_PROPERTY_MESSAGE = "property.messages";
    private static final String MESSAGE_EMPTY_LIST = "path.page.emptylist";

    private AlienTypeLogic logic;

    public ShowAlienTypesListCommand(AlienTypeLogic logic) {
        this.logic = logic;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        ResourceBundle configResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_CONFIG);

        HttpSession session = request.getSession();
        if(!"true".equals(session.getAttribute("authorise"))) {
            session.setAttribute("role", "guest");
        }

        List<AlienType> alienTypes = logic.findAllAlienTypes();
        if(alienTypes.isEmpty()) {
            ResourceBundle messageResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_MESSAGE);
            request.setAttribute("emptyList", messageResourceBundle.getString(MESSAGE_EMPTY_LIST));
        } else {
            request.setAttribute("alienTypes", alienTypes);
        }
        if("guest".equals(session.getAttribute("role"))) {
            router.setPagePath(configResourceBundle.getString(PATH_GUEST_MAIN_PAGE));
        } else {
            router.setPagePath(configResourceBundle.getString(PATH_USER_ALIEN_TYPES_LIST_PAGE));
        }
        router.setRoute(Router.RouteType.FORWARD);                                                  //уточнить!!!
        return router;
    }
}
