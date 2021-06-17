package by.epam.introduction_to_java.unit06.task01.presentation;

import by.epam.introduction_to_java.unit06.task01.bean.profile.Profile;

import java.util.List;

public interface ProfileActionViewI {
    String authorizationView (Profile result);
    String registrationView(boolean result);
    String errorView();
    String getMessagesView(List<String> result);
}
