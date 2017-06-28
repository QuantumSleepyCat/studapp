package by.samsolutionstud.commands.modelcommand;


import by.samsolution.utility.AttributesPars;
import by.samsolutionstud.filebase.strategy.FileStrategy;
import by.samsolutionstud.utility.GetterForm;

import java.util.Map;

/**
 * Created by QuantumCat on 27.06.2017.
 */
public class FindOptions {
    private String name;
    private String filename;
    private String dirname;
    private FileStrategy fileStrategy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setCommandParams(Map<String, String> commandParamsMap, String[] commandArguments) {
        this.name=commandParamsMap.get("name");
        this.filename = commandParamsMap.get("filename");
        this.dirname = commandParamsMap.get("dirname");
        this.fileStrategy = new GetterForm().getForm(filename);
    }
}
