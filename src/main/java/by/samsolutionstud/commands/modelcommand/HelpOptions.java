package by.samsolutionstud.commands.modelcommand;



import java.util.Map;

/**
 * Created by QuantumCat on 27.06.2017.
 */
public class HelpOptions {
    public String[] getArgumentsCommand() {
        return argumentsCommand;
    }

    private String[] argumentsCommand;
    public void setCommandParams(String[] commandArguments) {
        this.argumentsCommand=commandArguments;
    }
}
