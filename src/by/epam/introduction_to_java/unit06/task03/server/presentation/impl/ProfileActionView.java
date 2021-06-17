package by.epam.introduction_to_java.unit06.task03.server.presentation.impl;


import by.epam.introduction_to_java.unit06.task03.server.bean.EmptyProfile;
import by.epam.introduction_to_java.unit06.task03.server.bean.Profile;
import by.epam.introduction_to_java.unit06.task03.server.presentation.ProfileActionViewI;

public class ProfileActionView implements ProfileActionViewI {
    @Override
    public String authorizationView(Profile profile) {
        StringBuilder string = new StringBuilder();
        if (profile.getClass() != EmptyProfile.class){
            string.append("[access=").append(profile.getAccess()).append("][name=").append(profile.getName()).append("]");
        } else string.append("Error");
        return string.toString() + "\n";
    }

    @Override
    public String errorView() {
        return "Error\n";
    }
}
