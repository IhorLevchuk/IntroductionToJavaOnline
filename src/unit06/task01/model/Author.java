package unit06.task01.model;

import java.io.Serializable;

public class Author implements Serializable {
    private String surname;
    private String name;
    private String patronymic;

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
