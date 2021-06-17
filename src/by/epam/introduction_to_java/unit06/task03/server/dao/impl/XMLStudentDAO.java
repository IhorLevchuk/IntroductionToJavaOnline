package by.epam.introduction_to_java.unit06.task03.server.dao.impl;

import by.epam.introduction_to_java.unit06.task03.server.bean.Student;
import by.epam.introduction_to_java.unit06.task03.server.bean.EmptyStudent;
import by.epam.introduction_to_java.unit06.task03.server.dao.StudentDAO;
import by.epam.introduction_to_java.unit06.task03.server.exception.DAOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLStudentDAO implements StudentDAO {
    private static DocumentBuilder documentBuilder;
    private static String pathStudentFile = "src/by/epam/introduction_to_java/unit06/task03/server/resource/students.xml";

    public void writeStudentsInXML(List<Student> students) throws DAOException {
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
            StreamResult result = new StreamResult(new FileWriter(pathStudentFile));
            transformer.transform(source, result);
        } catch (TransformerException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    private Element parseStudent(Student student, Document document){
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

    public List<Student> readStudentsByXML() throws DAOException {
        List<Student> students = new ArrayList<>();
        getDocumentBuilder();
        Document document = null;
        try {
            document = documentBuilder.parse(pathStudentFile);
            Element root = document.getDocumentElement();
            NodeList studentsList = root.getElementsByTagName("student");
            for (int i = 0; i < studentsList.getLength(); i++) {
                Element studentElement = (Element) studentsList.item(i);
                Student student = buildStudent(studentElement);
                students.add(student);
            }
        } catch (IOException e) {
            throw new DAOException("File error or I/O error: ", e);
        } catch (SAXException e) {
            throw new DAOException("Parsing failure: ", e);
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

    private static void getDocumentBuilder() throws DAOException {
        if (documentBuilder == null){
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            try {
                documentBuilder = builderFactory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                throw new DAOException(e);
            }
        }
    }

    @Override
    public Student requestCase(int id) throws DAOException {
        for (Student student: readStudentsByXML()){
            if (student.getId() == id){
                return student;
            }
        }
        return new EmptyStudent();
    }

    @Override
    public void addCase(Student student) throws DAOException {
        boolean addCase = false;
        List<Student> students = readStudentsByXML();

        for (Student student1: students){
            if(student1.getId() == student.getId()){
                students.remove(student1);
                students.add(student);
                addCase = true;
                break;
            }
        }
        if (!addCase){
            students.add(student);
        }
        writeStudentsInXML(students);
    }
}
