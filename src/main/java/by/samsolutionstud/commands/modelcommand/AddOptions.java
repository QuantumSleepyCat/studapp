package by.samsolutionstud.commands.modelcommand;


import by.samsolutionstud.filebase.strategy.FileStrategy;
import by.samsolutionstud.utility.GetterForm;

import java.util.Map;

/**
 * Created by QuantumCat on 27.06.2017.
 */
public class AddOptions{
    private String name;
    private String surname;
    private String number;
    private String filename;
    private String dirname;
    private FileStrategy fileStrategy;
    private String[] argumentsCommand;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDirname() {
        return dirname;
    }

    public void setDirname(String dirname) {
        this.dirname = dirname;
    }

    public FileStrategy getFileStrategy() {
        return fileStrategy;
    }

    public void setFileStrategy(FileStrategy fileStrategy) {
        this.fileStrategy = fileStrategy;
    }

    public String[] getArgumentsCommand() {
        return argumentsCommand;
    }

    public void setArgumentsCommand(String[] argumentsCommand) {
        this.argumentsCommand = argumentsCommand;
    }

    public void setCommandParams(Map<String, String> commandParamsMap, String[] commandArguments) {
        this.name=commandParamsMap.get("name");
        this.surname = commandParamsMap.get("surname");
        this.number = commandParamsMap.get("number");
        this.filename = commandParamsMap.get("filename");
        this.dirname = commandParamsMap.get("dirname");
        this.fileStrategy = new GetterForm().getForm(filename);
    }
}
