import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentFileTests {

    @FileTest
    public void checkIvanovIvanIvanovichInJson() throws Exception {
        String jsonContent = Files.readString(Paths.get("..\\lesson_11_105\\IOStreams\\src\\students.json"));

        Pattern pattern = Pattern.compile("\"fullName\"\\s*:\\s*\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(jsonContent);

        boolean found = false;
        while (matcher.find()) {
            if ("DFD".equals(matcher.group(1))) {
                found = true;
                break;
            }
        }

        if (!found) {
            throw new AssertionError("не нашли студента dfd в файле json");
        }
    }

    @FileTest
    public void checkJsonFormatIsValid() throws Exception {
        String jsonContent = Files.readString(Paths.get("..\\lesson_11_105\\IOStreams\\src\\students.json")).trim();

        if (!jsonContent.startsWith("[") || !jsonContent.endsWith("]")) {
            throw new AssertionError("json должен быть массивом и начинаться с квадратной скобки");
        }

        Pattern studentPattern = Pattern.compile("\\{[^}]*\\}");
        Matcher matcher = studentPattern.matcher(jsonContent);

        int count = 0;
        while (matcher.find()) {
            count++;
            String student = matcher.group();

            if (!student.contains("\"id\"") || !student.contains("\"fullName\"") || !student.contains("\"averageGrade\"")) {
                throw new AssertionError("у какого-то студента не хватает полей id, name или grade");
            }
        }

        if (count == 0) {
            throw new AssertionError("Список студентов пустой, никого не нашли");
        }
    }

    @FileTest
    public void checkXMLMatchesJSON() throws Exception {
        String xmlContent = Files.readString(Paths.get("..\\lesson_11_105\\IOStreams\\src\\students.xml"));
        String jsonContent = Files.readString(Paths.get("..\\lesson_11_105\\IOStreams\\src\\students.json"));

        Pattern xmlPattern = Pattern.compile("<id>(\\d+)</id>\\s*<fullName>([^<]+)</fullName>\\s*<averageGrade>([\\d.]+)</averageGrade>");
        Matcher xmlMatcher = xmlPattern.matcher(xmlContent);

        List<String[]> xmlStudents = new ArrayList<>();
        while (xmlMatcher.find()) {
            xmlStudents.add(new String[]{xmlMatcher.group(1), xmlMatcher.group(2), xmlMatcher.group(3)});
        }

        Pattern jsonPattern = Pattern.compile("\"id\":\\s*(\\d+),\\s*\"fullName\":\\s*\"([^\"]+)\",\\s*\"averageGrade\":\\s*([\\d.]+)");
        Matcher jsonMatcher = jsonPattern.matcher(jsonContent);

        List<String[]> jsonStudents = new ArrayList<>();
        while (jsonMatcher.find()) {
            jsonStudents.add(new String[]{jsonMatcher.group(1), jsonMatcher.group(2), jsonMatcher.group(3)});
        }

        if (xmlStudents.size() != jsonStudents.size()) {
            throw new AssertionError("размер не совпал: в xml " + xmlStudents.size() + " человек, а в json " + jsonStudents.size());
        }

        for (int i = 0; i < xmlStudents.size(); i++) {
            String[] xmlStud = xmlStudents.get(i);
            String[] jsonStud = jsonStudents.get(i);

            if (!xmlStud[0].equals(jsonStud[0])) {
                throw new AssertionError("id не совпали на строчке " + i);
            }
            if (!xmlStud[1].equals(jsonStud[1])) {
                throw new AssertionError("Имена не совпали для id " + xmlStud[0]);
            }
            if (Double.parseDouble(xmlStud[2]) != Double.parseDouble(jsonStud[2])) {
                throw new AssertionError("Оценки не совпали для id " + xmlStud[0]);
            }
        }
    }
}