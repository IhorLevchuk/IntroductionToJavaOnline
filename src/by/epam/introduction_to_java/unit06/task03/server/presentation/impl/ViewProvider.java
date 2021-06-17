package by.epam.introduction_to_java.unit06.task03.server.presentation.impl;

import by.epam.introduction_to_java.unit06.task03.server.presentation.ProfileActionViewI;
import by.epam.introduction_to_java.unit06.task03.server.presentation.StudentActionViewI;

public class ViewProvider {
    private static final ViewProvider provider = new ViewProvider();

    private final ProfileActionViewI profileActionView = new ProfileActionView();
    private final StudentActionViewI studentActionView = new StudentActionView();

    private ViewProvider() {
    }

    public static ViewProvider getProvider() {
        return provider;
    }

    public ProfileActionViewI getProfileActionView() {
        return profileActionView;
    }

    public StudentActionViewI getStudentActionView() {
        return studentActionView;
    }
}
