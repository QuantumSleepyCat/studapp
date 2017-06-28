package by.samsolutionstud;

import by.samsolution.StudentsApplication;
import by.samsolution.StudentsApplicationBuilder;
import by.samsolution.commands.definition.CommandDefinition;
import by.samsolution.params.ParamDefinition;
import by.samsolutionstud.commands.AddCommand;
import by.samsolutionstud.commands.FindCommand;
import by.samsolutionstud.commands.HelpCommand;
import by.samsolutionstud.commands.ListCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by QuantumCat on 27.06.2017.
 */
public class EntryPointApplication {

    public static void main(String[] args) {
        List<ParamDefinition> paramsAdd = new ArrayList<ParamDefinition>();
        paramsAdd.add(new ParamDefinition("name"));
        paramsAdd.add(new ParamDefinition("surname"));
        paramsAdd.add(new ParamDefinition("number"));
        paramsAdd.add(new ParamDefinition("filename", false));
        paramsAdd.add(new ParamDefinition("dirname", false));
        List<ParamDefinition> paramsFind = new ArrayList<ParamDefinition>();
        paramsFind.add(new ParamDefinition("name"));
        paramsFind.add(new ParamDefinition("filename", false));
        paramsFind.add(new ParamDefinition("dirname", false));
        List<ParamDefinition> paramsList = new ArrayList<ParamDefinition>();
        paramsList.add(new ParamDefinition("filename", false));
        paramsList.add(new ParamDefinition("dirname", false));
        List<ParamDefinition> paramsHelp = new ArrayList<ParamDefinition>();
        paramsHelp.add(new ParamDefinition("add", false));
        paramsHelp.add(new ParamDefinition("find", false));
        paramsHelp.add(new ParamDefinition("list", false));
        Map<String, String> config = new HashMap<String, String>();
        config.put("filename", "students.txt");
        config.put("dirname", "stud");
        StudentsApplication application = new StudentsApplicationBuilder()
                .withCommand(new CommandDefinition("add", AddCommand.class, paramsAdd))
                .withCommand(new CommandDefinition("find", FindCommand.class, paramsFind))
                .withCommand(new CommandDefinition("list", ListCommand.class, paramsList))
                .withCommand(new CommandDefinition("help", HelpCommand.class, paramsHelp))
                .withConfig(config).build();
        application.run(args);
    }
}
