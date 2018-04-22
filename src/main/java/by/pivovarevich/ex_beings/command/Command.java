package by.pivovarevich.ex_beings.command;

import by.pivovarevich.ex_beings.controller.Router;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    Router execute(HttpServletRequest request);
    //void refresh(); //метод для возвращения на ту же самую страницу
}
