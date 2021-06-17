package by.epam.introduction_to_java.unit06.task01.controller.impl;

import by.epam.introduction_to_java.unit06.task01.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task01.presentation.ProfileActionViewI;
import by.epam.introduction_to_java.unit06.task01.presentation.impl.ViewProvider;
import by.epam.introduction_to_java.unit06.task01.service.ProfileServiceI;
import by.epam.introduction_to_java.unit06.task01.service.impl.ServiceProvider;

public class LogOutCommand implements by.epam.introduction_to_java.unit06.task01.controller.Command {
    @Override
    public String execute(String[] params) {
        ViewProvider viewProvider = ViewProvider.getProvider();
        ProfileActionViewI profileActionView = viewProvider.getProfileActionView();

        ServiceProvider serviceProvider = ServiceProvider.getProvider();
        ProfileServiceI profileService = serviceProvider.getProfileService();

        try {
            profileService.logOut();
        } catch (ServiceException e) {
            return profileActionView.errorView();
        }
        return "";
    }
}
