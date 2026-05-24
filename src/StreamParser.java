import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StreamParser {
    public static void convertXmlToJson(String xmlFile, String jsonFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile));
             BufferedReader reader = new BufferedReader(new FileReader(xmlFile))) {

            String line;
            boolean isFirstStudent = true;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                switch (line) {
                    case "<students>":
                        writer.write("[\n");
                        break;
                    case "</students>":
                        writer.write("\n]\n");
                        break;
                    case "<student>":
                        if (!isFirstStudent) writer.write(",\n");
                        writer.write("\t{\n");
                        isFirstStudent = false;
                        break;
                    case "</student>":
                        writer.write("\n\t}");
                        break;
                    default:
                        if (line.startsWith("<") && line.contains("</")) {
                            String[] tagsOnLine = line.replace("><", ">#<").split("#");

                            for (String singleTag : tagsOnLine) {
                                int startTagEnd = singleTag.indexOf(">");
                                int endTagStart = singleTag.indexOf("</");

                                String key = singleTag.substring(1, startTagEnd);
                                String value = singleTag.substring(startTagEnd + 1, endTagStart);

                                boolean isNumber = value.matches("\\d+(\\.\\d+)?");
                                String jsonValue = isNumber ? value : "\"" + value + "\"";

                                if (!key.equals("id")) {
                                    writer.write(",\n");
                                }
                                writer.write("\t\t\"" + key + "\": " + jsonValue);
                            }
                        }
                        break;
                }
            }
            System.out.println("JSON SAVED!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}