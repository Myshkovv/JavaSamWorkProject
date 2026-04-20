package tests;

import annotation.FileTest;

import java.nio.file.Files;
import java.nio.file.Paths;

public class StudentFileTests {

    @FileTest
    public void checkIvanovIvanIvanovichInJson() throws Exception {
        String content = Files.readString(Paths.get("students.json"));
        if (content.contains("Ivanov Ivan Ivanovich")) {
            System.out.println("checkIvanovIvanIvanovichInJson: PASSED");
        } else {
            throw new RuntimeException("checkIvanovIvanIvanovichInJson: FAILED");
        }
    }

    @FileTest
    public void checkJsonFormatIsValid() throws Exception {
        String content = Files.readString(Paths.get("students.json")).trim();
        if (content.startsWith("[") && content.endsWith("]")) {
            System.out.println("checkJsonFormatIsValid: PASSED");
        } else {
            throw new RuntimeException("checkJsonFormatIsValid: FAILED");
        }
    }

    @FileTest
    public void checkXMLMatchesJSON() throws Exception {
        String xml = Files.readString(Paths.get("students.xml"));
        String json = Files.readString(Paths.get("students.json"));

        long xmlCount = xml.split("<student>").length - 1;

        long jsonCount = json.split("\\{").length - 1;

        if (xmlCount == jsonCount && xmlCount > 0) {
            System.out.println("checkXMLMatchesJSON: PASSED, " + xmlCount + " students)");
        } else {
            throw new RuntimeException("XML has " + xmlCount + " students, but JSON has " + jsonCount);
        }
    }
}