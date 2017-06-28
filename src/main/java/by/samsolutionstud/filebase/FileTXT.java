package by.samsolutionstud.filebase;

import by.samsolutionstud.commands.modelcommand.AddOptions;
import by.samsolutionstud.commands.modelcommand.FindOptions;
import by.samsolutionstud.filebase.strategy.FileStrategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by QuantumCat on 10.06.2017.
 */
public class FileTXT implements FileStrategy {

    public List<String> getStudentsList(FindOptions commandOptions, String filename, String dirname, String status) throws IOException {
        List<String> students = null;
            BufferedReader reader=new BufferedReader(new FileReader(dirname+"/"+filename));
                students = new ArrayList<String>();
                String info = null;
                while ((info = reader.readLine()) != null) {
                    if(status.equals("all")) {
                        students.add(info);
                    }
                    else if(status.equals("findByName"))
                    {
                        if(info.contains(commandOptions.getName()))
                        {
                            students.add(info);
                        }
                    }
                }
                reader.close();
        return students;
    }

    public File createDirAdd(String dirname)
    {
        File dirAdd = new File(dirname);
        if(!dirAdd.exists())
        {
            dirAdd.mkdirs();
        }
        return dirAdd;
    }

    public File createFileAdd(File dirAdd, String filename) throws IOException {
        File fileAdd = new File(dirAdd,filename);
        if(!fileAdd.exists())
        {
            fileAdd.createNewFile();
        }
        return fileAdd;
    }

    public void addStudent(AddOptions commandOptions, String filename, String dirname) throws IOException {
            File dirAdd = createDirAdd(dirname);
            File fileAdd = createFileAdd(dirAdd,filename);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileAdd, true));
                  bufferedWriter.write(commandOptions.getName()+" "+
                  commandOptions.getSurname()+" "+
                  commandOptions.getNumber()+"\n");
                bufferedWriter.close();
    }
}
