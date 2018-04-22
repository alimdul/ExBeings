package by.pivovarevich.ex_beings.command;

public class ActionFactory {

    public static Command defineCommand(String commandName) {
        CommandType type = CommandType.valueOf(commandName.toUpperCase());
        Command command = type.getCommand();
        return command;
    }
}
