package by.epam.introduction_to_java.unit06.task03.server.controller.impl;


import by.epam.introduction_to_java.unit06.task03.server.controller.Command;
import by.epam.introduction_to_java.unit06.task03.server.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task03.server.presentation.ProfileActionViewI;
import by.epam.introduction_to_java.unit06.task03.server.presentation.impl.ViewProvider;
import by.epam.introduction_to_java.unit06.task03.server.service.ProfileServiceI;
import by.epam.introduction_to_java.unit06.task03.server.service.impl.ServiceProvider;

public class AuthorizationCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider serviceProvider = ServiceProvider.getProvider();
        ProfileServiceI profileService = serviceProvider.getProfileService();

        ViewProvider viewProvider = ViewProvider.getProvider();
        ProfileActionViewI profileActionView = viewProvider.getProfileActionView();

        String login, password;

        login = params[1].split("=")[1];
        password = params[2].split("=")[1];

        try {
            return profileActionView.authorizationView(profileService.validateClient(login,password));
        } catch (ServiceException e) {
            return profileActionView.errorView();
        }

    }
}
