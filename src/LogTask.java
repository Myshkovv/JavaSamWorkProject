import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class LogTask {
    private static final String FILE_NAME = "server_logs.txt";

    private boolean isError(String logLine) {
        String[] parts = logLine.split(" ");
        for (String part : parts) {
            if (part.equals("ERROR")) return true;
        }
        return false;
    }

    public void generateLogFile(int linesCount) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 1; i <= linesCount; i++) {
                if (i % 100 == 0) bw.write("2023-10-10 12:00:00 [Thread-" + i + "] ERROR Something failed\n");
                else bw.write("2023-10-10 12:00:00 [Thread-" + i + "] INFO Everything is fine\n");
            }
        }
    }


    public long processSingleThread() throws IOException {
        long count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (isError(line)) {
                    count++;
                }
            }
        }
        return count;
    }



    @Test
    void testLogProcessing() throws Exception {
        int totalLines = 2_000_000;
        generateLogFile(totalLines);
        int expectedErrors = totalLines / 100;

        long startSingle = System.currentTimeMillis();
        long singleResult = processSingleThread();
        long timeSingle = System.currentTimeMillis() - startSingle;

        System.out.println("IO Single: " + timeSingle + " ms");

        new File(FILE_NAME).delete();

        assertEquals(expectedErrors, singleResult, "Однопоточный посчитал неверно!");
    }
}