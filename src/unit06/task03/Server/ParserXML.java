package unit06.task03.Server;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ParserXML {
    private static DocumentBuilder documentBuilder;

    private static void getDocumentBuilder(){
        if (documentBuilder == null){
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            try {
                documentBuilder = builderFactory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeStudentsInXML(ArrayList<Student> students, String path){
        getDocumentBuilder();

        Document document = documentBuilder.newDocument();
        Element rootElement = document.createElement("students");
        document.appendChild(rootElement);
        for (Student student: students){
            rootElement.appendChild(parseStudent(student,document));
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileWriter(path));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Element parseStudent(Student student, Document document){
        Element element = document.createElement("student");
        element.setAttribute("id", String.valueOf(student.getId()));

        Element elementName = document.createElement("name");
        elementName.appendChild(document.createTextNode(student.getName()));

        Element elementFaculty = document.createElement("faculty");
        elementFaculty.appendChild(document.createTextNode(student.getFaculty()));

        Element elementAge = document.createElement("age");
        elementAge.appendChild(document.createTextNode(String.valueOf(student.getAge())));

        Element elementAverageMark = document.createElement("average-mark");
        elementAverageMark.appendChild(document.createTextNode(String.valueOf(student.getAverageMark())));

        element.appendChild(elementName);
        element.appendChild(elementFaculty);
        element.appendChild(elementAge);
        element.appendChild(elementAverageMark);

        return element;
    }

    public static ArrayList<Student> readStudentsByXML(String path){
        ArrayList<Student> students = new ArrayList<>();
        getDocumentBuilder();
        Document document = null;
        try {
            document = documentBuilder.parse(path);
            Element root = document.getDocumentElement();
            NodeList studentsList = root.getElementsByTagName("student");
            for (int i = 0; i < studentsList.getLength(); i++) {
                Element studentElement = (Element) studentsList.item(i);
                Student student = buildStudent(studentElement);
                students.add(student);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }

        return students;
    }

    private static Student buildStudent(Element studentElement){
        Student student = new Student();

        student.setId(Integer.parseInt(studentElement.getAttribute("id")));
        student.setName(getElementTextContent(studentElement,"name"));
        student.setFaculty(getElementTextContent(studentElement,"faculty"));
        student.setAge(Integer.parseInt(getElementTextContent(studentElement,"age")));
        student.setAverageMark(Integer.parseInt(getElementTextContent(studentElement,"average-mark")));

        return student;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

    public static ArrayList<Profile> readProfilesByXML(String path){
        ArrayList<Profile> profiles = new ArrayList<>();
        getDocumentBuilder();
        Document document = null;
        try {
            document = documentBuilder.parse(path);
            Element root = document.getDocumentElement();
            NodeList profileList = root.getElementsByTagName("profile");
            for (int i = 0; i < profileList.getLength(); i++) {
                Element studentElement = (Element) profileList.item(i);
                Profile profile = buildProfile(studentElement);
                profiles.add(profile);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }

        return profiles;
    }

    private static Profile buildProfile(Element profileElement){
        Profile profile = new Profile();

        profile.setAccess(Access.valueOf(profileElement.getAttribute("access")));
        profile.setName(getElementTextContent(profileElement,"name"));
        profile.setLogin(getElementTextContent(profileElement,"login"));
        profile.setRidingPassword(getElementTextContent(profileElement,"password"));

        return profile;
    }

    public static void writeProfilesInXML(ArrayList<Profile> profiles, String path){
        getDocumentBuilder();

        Document document = documentBuilder.newDocument();
        Element rootElement = document.createElement("profiles");
        document.appendChild(rootElement);
        for (Profile profile: profiles){
            rootElement.appendChild(parseProfile(profile,document));
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileWriter(path));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Element parseProfile(Profile profile, Document document){
        Element element = document.createElement("profile");
        element.setAttribute("access", String.valueOf(profile.getAccess()));

        Element elementName = document.createElement("name");
        elementName.appendChild(document.createTextNode(profile.getName()));

        Element elementLogin = document.createElement("login");
        elementLogin.appendChild(document.createTextNode(profile.getLogin()));

        Element elementPassword = document.createElement("password");

        elementPassword.appendChild(document.createTextNode(profile.getPassword()));

        element.appendChild(elementName);
        element.appendChild(elementLogin);
        element.appendChild(elementPassword);

        return element;
    }

}
