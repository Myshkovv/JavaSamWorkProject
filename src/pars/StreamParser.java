package pars;

import java.io.*;

public class StreamParser {

    public static void convertXmlToJson(String xmlFile, String jsonFile){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile));
             BufferedReader reader = new BufferedReader(new FileReader(xmlFile));
        ) {
            String line;
            boolean isFirstStudent = true;

            while((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.equals("<students>")) {
                    writer.write("[\n");
                } else if (line.equals("</students>")){
                    writer.write("\n]\n");
                } else if (line.equals("<student>")){
                    if (!isFirstStudent){
                        writer.write(",\n");
                    }
                    writer.write("\t{\n");
                    isFirstStudent = false;
                } else if (line.equals("</student>")){
                    writer.write("\n\t");
                } else if (line.startsWith("<") && line.contains("</")){
                    int startTagInt = line.indexOf(">");
                    int endTagStart = line.indexOf("</");
                }

            }

        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
