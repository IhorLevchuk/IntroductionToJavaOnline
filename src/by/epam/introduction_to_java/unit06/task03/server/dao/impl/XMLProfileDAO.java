package by.epam.introduction_to_java.unit06.task03.server.dao.impl;


import by.epam.introduction_to_java.unit06.task03.server.bean.EmptyProfile;
import by.epam.introduction_to_java.unit06.task03.server.bean.Profile;
import by.epam.introduction_to_java.unit06.task03.server.dao.ProfileDAO;
import by.epam.introduction_to_java.unit06.task03.server.enumeration.Access;
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

public class XMLProfileDAO implements ProfileDAO {
    private static String pathProfileFile = "src/by/epam/introduction_to_java/unit06/task03/server/resource/profiles.xml";
    private static DocumentBuilder documentBuilder;

    private void getDocumentBuilder() throws DAOException {
        if (documentBuilder == null){
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            try {
                documentBuilder = builderFactory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                throw new DAOException(e);
            }
        }
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

    public List<Profile> readProfilesByXML() throws DAOException {
        List<Profile> profiles = new ArrayList<>();
        getDocumentBuilder();
        Document document = null;
        try {
            document = documentBuilder.parse(pathProfileFile);
            Element root = document.getDocumentElement();
            NodeList profileList = root.getElementsByTagName("profile");
            for (int i = 0; i < profileList.getLength(); i++) {
                Element studentElement = (Element) profileList.item(i);
                Profile profile = buildProfile(studentElement);
                profiles.add(profile);
            }
        } catch (IOException e) {
            throw new DAOException("File error or I/O error: ", e);
        } catch (SAXException e) {
            throw new DAOException("Parsing failure: ", e);
        }

        return profiles;
    }

    private Profile buildProfile(Element profileElement){
        Profile profile = new Profile();

        profile.setAccess(Access.valueOf(profileElement.getAttribute("access")));
        profile.setName(getElementTextContent(profileElement,"name"));
        profile.setLogin(getElementTextContent(profileElement,"login"));
        profile.setPassword(getElementTextContent(profileElement,"password"));

        return profile;
    }

    private void writeProfilesInXML(List<Profile> profiles) throws DAOException {
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
            StreamResult result = new StreamResult(new FileWriter(pathProfileFile));
            transformer.transform(source, result);
        } catch (TransformerException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    private Element parseProfile(Profile profile, Document document){
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

    @Override
    public void addProfile(Profile profile) throws DAOException {
        List<Profile> profiles = readProfilesByXML();
        profiles.add(profile);
        writeProfilesInXML(profiles);
    }

    @Override
    public Profile validateClient(String login, String password) throws DAOException {
        for (Profile profile: readProfilesByXML()){
            if (profile.getLogin().equals(login) && profile.getPassword().equals(password)){
                return profile;
            }
        }
        return new EmptyProfile();
    }
}
