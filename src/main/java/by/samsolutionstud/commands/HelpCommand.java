package by.samsolutionstud.commands;

import by.samsolution.commands.Command;
import by.samsolutionstud.commands.modelcommand.HelpOptions;

import java.util.Map;

/**
 * Created by QuantumCat on 20.06.2017.
 */
public class HelpCommand implements Command {
    public void execute(Map<String,String> commandArgumentsMap, String[] commandArguments) {
        HelpOptions helpOptions = new HelpOptions();
        helpOptions.setCommandParams(commandArguments);
        if(helpOptions.getArgumentsCommand().length==1)
        {
            System.out.println("add - добавить запись в файл\n" +
                    "find - найти запись в файле\n" +
                    "list - вывести весь список записей\n" +
                    "help название_метода - подробная информация об использовании метода");
        }
        else if(helpOptions.getArgumentsCommand().length==2)
        {
            if(helpOptions.getArgumentsCommand()[1].equals("--find"))
            {
                System.out.println("find --name=имя_студента [--filename=имя_файла] [--dirname=директрория]\n" +
                        "\n" +
                        "--name - указывается имя студента в базе\n" +
                        "--surname - указывается фамилия студента в базе\n" +
                        "--filename - указывается файл, в котором хранится список студентов, доступные форматы .txt, " +
                        ".xml, по умолчанию students.txt\n" +
                        "--dirname - название директории, в которой хранится файл с данными, по умолчанию stud");
            }
            else if(helpOptions.getArgumentsCommand()[1].equals("--add"))
            {
                System.out.println("add --name=имя_студента --surname=фамилия_студента --number=номер_зачётной_книжки" +
                        " [--filename=имя_файла] [--dirname=директрория]\n" +
                        "\n" +
                        "--name - указывается имя студента для добавления в базу\n" +
                        "--surname - указывается фамилия студента для добавления в базу\n" +
                        "--number - указывается номер зачётной книжки студента для добавления в базу\n" +
                        "--filename - указывается файл, в котором хранится список студентов, доступные форматы .txt, .xml," +
                        " по умолчанию students.txt\n" +
                        "--dirname - название директории, в которой хранится файл с данными, по умолчанию stud");
            }
            else if(helpOptions.getArgumentsCommand()[1].equals("--list"))
            {
                System.out.println("list [--filename=имя_файла] [--dirname=директрория]\n" +
                        "\n" +
                        "--filename - указывается файл, в котором хранится список студентов, доступные форматы " +
                        ".txt, .xml, по умолчанию students.txt\n" +
                        "--dirname - название директории, в которой хранится файл с данными, по умолчанию stud");
            }
            else
            {
                throw new RuntimeException("Параметры введены неверно!");
            }
        }
        else
        {
            throw new RuntimeException("Параметры введены неверно!");
        }
    }
}
