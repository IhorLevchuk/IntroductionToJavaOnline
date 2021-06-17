package by.epam.introduction_to_java.unit06.task03.server.service.impl;

import by.epam.introduction_to_java.unit06.task03.server.service.ProfileServiceI;
import by.epam.introduction_to_java.unit06.task03.server.service.StudentServiceI;

public final class ServiceProvider {
    private static final ServiceProvider provider = new ServiceProvider();

    private final ProfileServiceI profileService = new ProfileService();
    private final StudentServiceI studentService = new StudentService();

    private ServiceProvider() {
    }

    public static ServiceProvider getProvider(){
        return provider;
    }

    public ProfileServiceI getProfileService() {
        return profileService;
    }

    public StudentServiceI getStudentService() {
        return studentService;
    }
}
