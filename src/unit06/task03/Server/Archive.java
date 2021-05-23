package unit06.task03.Server;

import java.util.ArrayList;
import java.util.Base64;

public class Archive{
    private String pathStudentFile = "src/unit06/task03/resources/students.xml";
    private String pathProfileFile = "src/unit06/task03/resources/profiles.xml";
    private ArrayList<Profile> profiles;
    private ArrayList<Student> students;

    public Archive() {
        students = ParserXML.readStudentsByXML(pathStudentFile);
        profiles = ParserXML.readProfilesByXML(pathProfileFile);
    }

    public Student requestCase(int id){
        for (Student student: students){
            if (student.getId() == id){
                return student;
            }
        }
        return null;
    }

    public void addCase(Student student){
        students.add(student);
        saveArchive();
    }

    public void addProfile(Profile profile){
        profiles.add(profile);
        saveArchive();
    }

    public void saveArchive(){
        ParserXML.writeStudentsInXML(students, pathStudentFile);
        ParserXML.writeProfilesInXML(profiles, pathProfileFile);
    }

    public boolean validateClient(String login, String password){
        for (Profile profile: profiles){
            if (profile.getLogin().equals(login) && profile.getPassword().equals(Base64.getEncoder().encodeToString(Profile.getHash(password)))){
                return true;
            }
        }
        return false;
    }
    public Profile getClient(String login, String password){
        for (Profile profile: profiles){
            if (profile.getLogin().equals(login) && profile.getPassword().equals(Base64.getEncoder().encodeToString(Profile.getHash(password)))){
                return profile;
            }
        }
        return null;
    }
}
