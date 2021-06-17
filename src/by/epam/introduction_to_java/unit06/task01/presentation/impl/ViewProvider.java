package by.epam.introduction_to_java.unit06.task01.presentation.impl;

import by.epam.introduction_to_java.unit06.task01.presentation.BookActionViewI;
import by.epam.introduction_to_java.unit06.task01.presentation.ProfileActionViewI;

public class ViewProvider {
    private static final ViewProvider provider = new ViewProvider();

    BookActionViewI bookActionView = new BookActionView();
    ProfileActionViewI profileActionView = new ProfileActionView();

    private ViewProvider() {
    }

    public static ViewProvider getProvider(){
        return provider;
    }

    public BookActionViewI getBookActionView() {
        return bookActionView;
    }

    public ProfileActionViewI getProfileActionView() {
        return profileActionView;
    }
}
