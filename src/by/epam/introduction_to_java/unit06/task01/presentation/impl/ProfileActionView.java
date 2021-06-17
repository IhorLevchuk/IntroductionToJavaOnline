package by.epam.introduction_to_java.unit06.task01.presentation.impl;

import by.epam.introduction_to_java.unit06.task01.bean.profile.Profile;
import by.epam.introduction_to_java.unit06.task01.presentation.ProfileActionViewI;

import java.util.List;

public class ProfileActionView implements ProfileActionViewI {
    @Override
    public String authorizationView(Profile result) {

        if(result.getClass() != Profile.class){
            return "Вход выполнен успешно. \n" + "Вы вошли как \n" + result.getClass().getSimpleName() + " " +
                    result.getAllName();
        } else {
            return "Неверный логин или пароль.";
        }
    }

    @Override
    public String registrationView(boolean result) {
        if(result){
            return "Регистация завершена успешно.";
        } else return "Регестрация не выполнена.";
    }


    @Override
    public String errorView() {
        return "Error";
    }

    @Override
    public String getMessagesView(List<String> result) {
        StringBuilder stringMassage = new StringBuilder();
        for (String message: result){
            stringMassage.append(message).append("\n");
        }
        return stringMassage.toString();
    }
}
