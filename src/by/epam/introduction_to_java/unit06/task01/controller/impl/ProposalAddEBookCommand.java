package by.epam.introduction_to_java.unit06.task01.controller.impl;

import by.epam.introduction_to_java.unit06.task01.controller.Command;
import by.epam.introduction_to_java.unit06.task01.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task01.presentation.ProfileActionViewI;
import by.epam.introduction_to_java.unit06.task01.presentation.impl.ViewProvider;
import by.epam.introduction_to_java.unit06.task01.service.ProfileServiceI;
import by.epam.introduction_to_java.unit06.task01.service.impl.ServiceProvider;

public class ProposalAddEBookCommand implements Command {
    @Override
    public String execute(String[] params) {
        ViewProvider viewProvider = ViewProvider.getProvider();
        ProfileActionViewI profileActionView = viewProvider.getProfileActionView();

        ServiceProvider serviceProvider = ServiceProvider.getProvider();
        ProfileServiceI profileService = serviceProvider.getProfileService();

        String author, name, id, pages;
        id = params[1].split("=")[1];
        author = params[2].split("=")[1];
        pages = params[3].split("=")[1];
        name = params[4].split("=")[1];

        try {
            profileService.sendMessageWithProposalEBook(Integer.parseInt(id),author,Integer.parseInt(pages),name);
            return "";
        } catch (ServiceException e) {
            return profileActionView.errorView();
        }
    }
}
