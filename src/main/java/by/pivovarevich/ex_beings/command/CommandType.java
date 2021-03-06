package by.pivovarevich.ex_beings.command;

import by.pivovarevich.ex_beings.logic.AlienLogic;
import by.pivovarevich.ex_beings.logic.AlienTypeLogic;
import by.pivovarevich.ex_beings.logic.UserLogic;

public enum CommandType {

    LOGIN(new LoginCommand(new UserLogic())),
    REGISTER(new RegisterCommand(new UserLogic())),
    LOGOUT(new LogoutCommand()),
    SHOW_ALIEN_TYPES_LIST(new ShowAlienTypesListCommand(new AlienTypeLogic())),
    SHOW_ALIEN(new ShowAlienCommand(new AlienLogic())),
    SHOW_ALIEN_TYPE(new ShowAlienTypeCommand(new AlienTypeLogic())),
    SUGGEST(new SuggestAlienCommand(new AlienLogic()));

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
