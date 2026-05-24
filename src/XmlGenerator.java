
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XmlGenerator {
    public static void generateXml(List<Student> students, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("<students>\n");
            for (Student student : students) {
                writer.write("\t<student>\n");
                writer.write("\t\t<id>" + student.id + "</id><fullName>" + student.fullName + "</fullName><averageGrade>" + student.averageGrade + "</averageGrade>\n");
                writer.write("\t</student>\n");
            }
            writer.write("</students>\n");
            System.out.println("XML DONE" + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}