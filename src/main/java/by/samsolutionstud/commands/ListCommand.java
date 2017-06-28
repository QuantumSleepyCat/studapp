package by.samsolutionstud.commands;

import by.samsolution.commands.Command;
import by.samsolutionstud.commands.modelcommand.FindOptions;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by QuantumCat on 20.06.2017.
 */
public class ListCommand implements Command {
    public void execute(Map<String,String> commandArgumentsMap, String[] commandArguments) throws ParserConfigurationException, SAXException, IOException {
        FindOptions findOptions = new FindOptions();
        findOptions.setCommandParams(commandArgumentsMap,commandArguments);
        for(String student:findOptions.getFileStrategy().getStudentsList(findOptions,findOptions.getFilename(),
                findOptions.getDirname(),"all"))
        {
            System.out.println(student);
        }
    }
}
