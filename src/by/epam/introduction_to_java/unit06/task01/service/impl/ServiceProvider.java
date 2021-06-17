package by.epam.introduction_to_java.unit06.task01.service.impl;


import by.epam.introduction_to_java.unit06.task01.service.BookServiceI;
import by.epam.introduction_to_java.unit06.task01.service.ProfileServiceI;

public class ServiceProvider {
    private static final ServiceProvider provider = new ServiceProvider();

    private final BookServiceI bookService = new BookService();
    private final ProfileServiceI profileService = new ProfileService();

    private ServiceProvider() {
    }

    public static ServiceProvider getProvider(){
        return provider;
    }

    public BookServiceI getBookService() {
        return bookService;
    }

    public ProfileServiceI getProfileService() {
        return profileService;
    }
}
