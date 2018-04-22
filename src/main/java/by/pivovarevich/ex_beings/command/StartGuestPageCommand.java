package by.pivovarevich.ex_beings.command;

import by.pivovarevich.ex_beings.controller.Router;
import by.pivovarevich.ex_beings.entity.AlienType;
import by.pivovarevich.ex_beings.logic.AlienTypeLogic;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ResourceBundle;

public class StartGuestPageCommand implements Command {

    private static final String PATH_PROPERTY_CONFIG = "property.config";
    private static final String PATH_GUEST_MAIN_PAGE = "path.page.guestmain";
    private static final String PATH_PROPERTY_MESSAGE = "property.messages";
    private static final String MESSAGE_EMPTY_LIST = "path.page.emptylist";

    private AlienTypeLogic logic;

    public StartGuestPageCommand(AlienTypeLogic logic) {
        this.logic = logic;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        ResourceBundle configResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_CONFIG);
        //List<Alien> aliens;

        request.getSession().setAttribute("role", "guest");

        List<AlienType> alienTypes = logic.findAllAlienTypes();
        if(alienTypes.isEmpty()) {
            ResourceBundle messageResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_MESSAGE);
            request.setAttribute("emptyList", messageResourceBundle.getString(MESSAGE_EMPTY_LIST));
        } else {
            request.setAttribute("alienTypes", alienTypes);
        }
        router.setRoute(Router.RouteType.FORWARD);                                                  //уточнить!!!
        router.setPagePath(configResourceBundle.getString(PATH_GUEST_MAIN_PAGE));
        return router;


//        aliens = logic.findAllAliens();
//        if(!aliens.isEmpty()) {
//            request.setAttribute("alienList", aliens);
//        } else {
//            ResourceBundle messageResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_MESSAGE);
//            request.setAttribute("emptyList", messageResourceBundle.getString(MESSAGE_EMPTY_LIST));
//        }
//        router.setRoute(Router.RouteType.FORWARD);                                                  //уточнить!!!
//        router.setPagePath(configResourceBundle.getString(PATH_GUEST_MAIN_PAGE));
//        return router;
    }
}
