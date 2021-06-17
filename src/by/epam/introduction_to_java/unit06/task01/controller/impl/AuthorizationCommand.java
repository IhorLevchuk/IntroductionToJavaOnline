package by.epam.introduction_to_java.unit06.task01.controller.impl;

import by.epam.introduction_to_java.unit06.task01.controller.Command;
import by.epam.introduction_to_java.unit06.task01.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task01.presentation.ProfileActionViewI;
import by.epam.introduction_to_java.unit06.task01.presentation.impl.ViewProvider;
import by.epam.introduction_to_java.unit06.task01.service.ProfileServiceI;
import by.epam.introduction_to_java.unit06.task01.service.impl.ServiceProvider;

public class AuthorizationCommand implements Command {
    @Override
    public String execute(String[] params) {
        ViewProvider viewProvider = ViewProvider.getProvider();
        ProfileActionViewI profileActionView = viewProvider.getProfileActionView();

        ServiceProvider serviceProvider = ServiceProvider.getProvider();
        ProfileServiceI profileService = serviceProvider.getProfileService();

        String login = params[1].split("=")[1];
        String password = params[2].split("=")[1];
        try {
            return profileActionView.authorizationView(profileService.authorization(login,password));
        } catch (ServiceException e) {
            return profileActionView.errorView();
        }
    }
}
