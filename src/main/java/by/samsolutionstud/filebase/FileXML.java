package by.samsolutionstud.filebase;

import by.samsolutionstud.commands.modelcommand.AddOptions;
import by.samsolutionstud.commands.modelcommand.FindOptions;
import by.samsolutionstud.filebase.strategy.FileStrategy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by QuantumCat on 10.06.2017.
 */
public class FileXML implements FileStrategy {

    private String errorFile = "Документ не соответсвует правильной структуре! Корневым тегом в документе должен" +
            " являться <students>";

    public List<String> getStudentsList(FindOptions commandOptions, String filename, String dirname, String status) throws IOException, SAXException, ParserConfigurationException {
        List<String> students=new ArrayList<String>();
            Document document = getDoc(filename, dirname);
            Element first = document.getDocumentElement();
            if(first.getTagName().equals("students"))
            {
                NodeList studs=first.getElementsByTagName("student");
                for(int i=0;i<studs.getLength();i++)
                {
                    StringBuilder student = new StringBuilder();
                    Element stud = (Element)studs.item(i);
                    NodeList args = stud.getElementsByTagName("*");
                    for(int j=0; j<args.getLength();j++)
                    {

                        Element arg=(Element)args.item(j);
                        if(arg.getTagName().equals("name"))
                        {
                            student.append(arg.getTextContent()+ " ");
                        }
                        else if(arg.getTagName().equals("surname"))
                        {
                            student.append(arg.getTextContent()+" ");
                        }
                        else if(arg.getTagName().equals("number"))
                        {
                            student.append(arg.getTextContent());
                        }

                    }
                    if(status.equals("all")) {
                        students.add(student.toString());
                    }
                    else if(status.equals("findByName"))
                    {
                        if(student.toString().contains(commandOptions.getName()))
                        {
                            students.add(student.toString());
                        }
                    }
                }
            }
            else
            {
                System.err.println(this.errorFile);
                System.exit(0);
            }
        return students;
    }

    public Document getDoc(String fileName, String dirName) throws ParserConfigurationException, IOException, SAXException {
        File file = new File(dirName,fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringComments(true);
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return (Document) builder.parse(file);
    }

    public void addStudent(AddOptions commandOptions, String filename, String dirname) throws IOException, SAXException, ParserConfigurationException, TransformerException {
            Document document = getDoc(filename, dirname);
            Element first = document.getDocumentElement();
            if(first.getTagName().equals("students"))
            {
                Element stud = document.createElement("student");
                first.appendChild(stud);
                Element name = document.createElement("name");
                name.setTextContent(commandOptions.getName());
                stud.appendChild(name);
                Element surname = document.createElement("surname");
                surname.setTextContent(commandOptions.getSurname());
                stud.appendChild(surname);
                Element number = document.createElement("number");
                number.setTextContent(commandOptions.getNumber());
                stud.appendChild(number);
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(new File(dirname,filename));
                transformer.transform(source, result);
            }
            else
            {
                System.err.println(this.errorFile);
                System.exit(0);
            }
    }
}
