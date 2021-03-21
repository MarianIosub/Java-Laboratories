package Shell;

import Catalog.Catalog;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand {
    public static void getReport(Catalog catalog) throws IOException {
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_29);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setDirectoryForTemplateLoading(new File("D:\\Facultate\\Java\\Laborator5\\Lab5_optional\\"));
        Map<String,Object> mapForHTML=new HashMap<>();
        mapForHTML.put("name",catalog.getName());
        mapForHTML.put("items",catalog.getCatalog().toString());
        Template template=configuration.getTemplate("Template.html");
        Writer writer=new FileWriter("D:\\Facultate\\Java\\Laborator5\\Lab5_optional\\Report.html");
        try{
            template.process(mapForHTML,writer);
        }catch(Exception exception){
            exception.printStackTrace();
        }
        writer.close();
        File file = new File("D:\\Facultate\\Java\\Laborator5\\Lab5_optional\\Report.html");
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
    }
}
