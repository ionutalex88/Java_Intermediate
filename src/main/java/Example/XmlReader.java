package Example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class XmlReader {

    public Document readXML(String path) throws ParserConfigurationException, IOException, SAXException {
        File fXmlFile = new File(path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        //optional, but recommended
        doc.getDocumentElement().normalize();

        return doc;
    }

    public HashMap profileLoader(Document document, String requestedProfile) throws Exception {
        boolean profileFound = false;
        HashMap map = new HashMap();

        NodeList nList = document.getElementsByTagName("profile");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String profile = eElement.getAttribute("name");

                if (profile.equals(requestedProfile)) {

                    System.out.println("Profile : " + profile);
                    profileFound = true;

                    String homepage = eElement.getElementsByTagName("homepage").item(0).getTextContent();
                    map.put("homepage", homepage);
                    System.out.println("homepage : " + homepage);

                    String browser = eElement.getElementsByTagName("browser").item(0).getTextContent();
                    map.put("browser", browser);
                    System.out.println("browser : " + browser);

                    String language = eElement.getElementsByTagName("language").item(0).getTextContent();
                    map.put("language", language);
                    System.out.println("language : " + language);

                    break;
                }
            }
        }


        if (!profileFound) {
            throw new Exception("Profile: " + requestedProfile + " NOT FOUND");
        }

        System.out.println("----------------------------");

        return map;
    }


}
