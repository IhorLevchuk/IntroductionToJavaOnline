package by.epam.introduction_to_java.unit06.task03.server.presentation;


import by.epam.introduction_to_java.unit06.task03.server.bean.Profile;

public interface ProfileActionViewI {
    String authorizationView(Profile profile);
    String errorView();
}
