package by.pivovarevich.ex_beings.command;

import by.pivovarevich.ex_beings.controller.Router;
import by.pivovarevich.ex_beings.logic.AlienLogic;

import javax.servlet.http.HttpServletRequest;

public class SuggestAlienCommand implements Command {

    private static final String PATH_PROPERTY_CONFIG = "property.config";
    private static final String PATH_GUEST_MAIN_PAGE = "path.page.guestmain";
    private static final String PATH_USER_ALIEN_TYPES_LIST_PAGE = "path.page.useralientypelist";
    private static final String PATH_PROPERTY_MESSAGE = "property.messages";
    private static final String MESSAGE_EMPTY_LIST = "path.page.emptylist";

    private AlienLogic logic;

    public SuggestAlienCommand(AlienLogic logic) {
        this.logic = logic;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        return null;
    }
}
