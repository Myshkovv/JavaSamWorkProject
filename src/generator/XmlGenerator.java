package generator;

import models.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XmlGenerator {

    public static void generateXml(List<Student> students, String filename){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("<students>\n");
            for (Student student : students){
                writer.write("\t<student>\n");
                writer.write("\t\t<id>" + student.id + "</id>");
                writer.write("\t\t<fullName>" + student.fullName + "</fullName>");
                writer.write("\t\tav" + student.averageGrade + "</averageGrade>");
                writer.write("\t<student>\n");
            }
            writer.write("\t<students>\n");
            System.out.println("xml done" + filename);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
