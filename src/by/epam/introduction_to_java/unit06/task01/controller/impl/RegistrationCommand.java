package by.epam.introduction_to_java.unit06.task01.controller.impl;

import by.epam.introduction_to_java.unit06.task01.controller.Command;
import by.epam.introduction_to_java.unit06.task01.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task01.presentation.ProfileActionViewI;
import by.epam.introduction_to_java.unit06.task01.presentation.impl.ViewProvider;
import by.epam.introduction_to_java.unit06.task01.service.ProfileServiceI;
import by.epam.introduction_to_java.unit06.task01.service.impl.ServiceProvider;

public class RegistrationCommand implements Command {
    @Override
    public String execute(String[] params) {
        ViewProvider viewProvider = ViewProvider.getProvider();
        ProfileActionViewI profileActionView = viewProvider.getProfileActionView();

        ServiceProvider serviceProvider = ServiceProvider.getProvider();
        ProfileServiceI profileService = serviceProvider.getProfileService();

        String surname, name, patronymic, email, login, password;
        surname = params[1].split("=")[1];
        name = params[2].split("=")[1];
        patronymic = params[3].split("=")[1];
        email = params[4].split("=")[1];
        login = params[5].split("=")[1];
        password = params[6].split("=")[1];

        try {
            return profileActionView.registrationView(profileService.registration(surname,name,patronymic,email,login,password));
        } catch (ServiceException e) {
            return profileActionView.errorView();
        }
    }
}
