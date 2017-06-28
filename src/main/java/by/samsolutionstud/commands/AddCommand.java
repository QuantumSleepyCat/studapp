package by.samsolutionstud.commands;


import by.samsolution.commands.Command;

import by.samsolutionstud.commands.modelcommand.AddOptions;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Map;


/**
 * Created by QuantumCat on 20.06.2017.
 */
public class AddCommand implements Command{
    public void execute(Map<String,String> commandArgumentsMap, String[] commandArguments) throws SAXException, TransformerException, ParserConfigurationException, IOException {
        AddOptions addOptions = new AddOptions();
        addOptions.setCommandParams(commandArgumentsMap,commandArguments);
           addOptions.getFileStrategy().addStudent(addOptions,addOptions.getFilename(),addOptions.getDirname());
           System.out.println("Студент успешно добавлен");
    }
}