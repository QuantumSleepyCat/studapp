package by.samsolutionstud.utility;


import by.samsolutionstud.filebase.FileTXT;
import by.samsolutionstud.filebase.FileXML;
import by.samsolutionstud.filebase.strategy.FileStrategy;

/**
 * Created by QuantumCat on 10.06.2017.
 */
public class GetterForm {

    public FileStrategy getForm(String arg)
    {
        String[] attr = arg.split("\\Q.\\E");
        if(attr.length==1)
        {
            throw new RuntimeException("Неверный формат файла");
        }
        else if(attr[1].equals("xml"))
        {
            return new FileXML();
        }
        else if(attr[1].equals("txt"))
        {
            return new FileTXT();
        }
        else
        {
            throw new RuntimeException("Неверный формат файла");
        }
    }
}
