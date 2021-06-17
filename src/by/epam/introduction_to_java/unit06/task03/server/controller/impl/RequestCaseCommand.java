package by.epam.introduction_to_java.unit06.task03.server.controller.impl;

import by.epam.introduction_to_java.unit06.task03.server.controller.Command;
import by.epam.introduction_to_java.unit06.task03.server.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task03.server.presentation.StudentActionViewI;
import by.epam.introduction_to_java.unit06.task03.server.presentation.impl.ViewProvider;
import by.epam.introduction_to_java.unit06.task03.server.service.StudentServiceI;
import by.epam.introduction_to_java.unit06.task03.server.service.impl.ServiceProvider;

public class RequestCaseCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider serviceProvider = ServiceProvider.getProvider();
        StudentServiceI studentService = serviceProvider.getStudentService();

        ViewProvider viewProvider = ViewProvider.getProvider();
        StudentActionViewI studentActionView = viewProvider.getStudentActionView();

        String id = params[1].split("=")[1];

        try {
            return studentActionView.requestCaseView(studentService.requestCase(id));
        } catch (ServiceException e) {
            return studentActionView.errorView();
        }
    }
}
