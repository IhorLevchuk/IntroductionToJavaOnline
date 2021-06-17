package by.epam.introduction_to_java.unit06.task03.server.controller.impl;


import by.epam.introduction_to_java.unit06.task03.server.controller.Command;
import by.epam.introduction_to_java.unit06.task03.server.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task03.server.presentation.StudentActionViewI;
import by.epam.introduction_to_java.unit06.task03.server.presentation.impl.ViewProvider;
import by.epam.introduction_to_java.unit06.task03.server.service.StudentServiceI;
import by.epam.introduction_to_java.unit06.task03.server.service.impl.ServiceProvider;

public class ChangeCaseCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider serviceProvider = ServiceProvider.getProvider();
        StudentServiceI studentService = serviceProvider.getStudentService();

        ViewProvider viewProvider = ViewProvider.getProvider();
        StudentActionViewI studentActionView = viewProvider.getStudentActionView();

        String id, name, faculty, age, averageMark;
        id = params[1].split("=")[1];
        name = params[2].split("=")[1];
        faculty = params[3].split("=")[1];
        age = params[4].split("=")[1];
        averageMark = params[5].split("=")[1];

        try {
            return studentActionView.changeCaseView(studentService.changeCase(id,name,faculty,age,averageMark));
        } catch (ServiceException e) {
            return studentActionView.errorView();
        }
    }
}
